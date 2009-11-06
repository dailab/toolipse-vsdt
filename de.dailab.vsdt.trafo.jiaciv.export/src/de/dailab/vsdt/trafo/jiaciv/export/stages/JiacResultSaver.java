package de.dailab.vsdt.trafo.jiaciv.export.stages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import de.dailab.jadltools.model.tree.JADLDocument;
import de.dailab.jadltools.model.visitor.JADLSourceVisitor;
import de.dailab.jadltools.model.xmlbind.JADLFileModel;
import de.dailab.jadltools.model.xmlbind.Jadlfile;
import de.dailab.jiaciv.agentrole.AgentRoleFactory;
import de.dailab.jiaciv.agentrole.AgentRoleType;
import de.dailab.jiaciv.agentrole.DocumentRoot;
import de.dailab.jiaciv.agentrole.util.AgentRoleResourceFactoryImpl;
import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;
import de.dailab.vsdt.trafo.jiaciv.export.JiacVisitorConstants;

public class JiacResultSaver extends MappingResultSaver implements JiacVisitorConstants{

	/**
	 * Save the result to a JADL file for each pool/process in the diagram.
	 * Additionally the content of the log list can be saved to a text file.
	 * 
	 * @param folder	folder where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		boolean ok= true;
		for (Object object : wrapper.getTargetModels()) {

			if (object instanceof JADLFileModel) {
				JADLFileModel jadlFileModel = (JADLFileModel) object;
				File file= new File(baseDirectory, jadlFileModel.getFile() + ".jadl");
				try {
					Jadlfile jadlFile= jadlFac.createJadlfile();
					jadlFile.setValueObject(jadlFileModel);
	//				jadlFileModel.setPackage(dName);
					
					JADLSourceVisitor v = new JADLSourceVisitor();
					((JADLDocument) jadlFile).acceptVisitor(v);
					String source = v.getJADLsource();
					
					System.out.println(source);
					
					BufferedWriter out= new BufferedWriter(new FileWriter(file));
					out.write(source);
					out.flush();
					out.close();
				} catch (JAXBException e) {
					TrafoLog.error(e.getMessage());
				}
			}
			if (object instanceof AgentRoleType) {
				AgentRoleType agent = (AgentRoleType) object;

				//create document root for agent
				DocumentRoot docRoot= AgentRoleFactory.eINSTANCE.createDocumentRoot();
				docRoot.getAgentRole().add(agent);

				String name= baseDirectory + agent.getName().replaceFirst(agent.getPackage()+".", "");
				
				AgentRoleResourceFactoryImpl agentResFac= new AgentRoleResourceFactoryImpl();
				Resource agentRes= agentResFac.createResource(URI.createFileURI(name + ".agentrole"));
				agentRes.getContents().add(docRoot);
				agentRes.save(null);
			}
		}
		return ok;
	}
	
	
}
