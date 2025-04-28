package de.dailab.common.swt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

/**
 * This class is used to retrieve all resources in the workspace. It is needed to get all possible
 * BPMN files holding other Business Process Diagrams to be referenced in a Independent Subprocess.
 * 
 * @author tkuester
 */
public class ResourceFinder {
	
	/**
	 * Get all resources in the workspace with a given extension.
	 * 
	 * @param resource	some resource in the workspace
	 * @param extension	desired file extension or null, if all extensions shall be accepted
	 * @return			list with all resources matching the extension
	 * @generated NOT
	 */
	public static List<Resource> getResources(Resource resource, String extension) {
		List<Resource> resources= new ArrayList<Resource>();
		ResourceSet resourceSet= new ResourceSetImpl();
		
		IFile file= WorkspaceSynchronizer.getFile(resource);
		IProject[] projects= file.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			if (project.isOpen()) {
				List<IResource> members= getLeafMembers(project, extension);
				for (IResource member: members) {
					try {
						String path= new File(member.getLocationURI()).getAbsolutePath();
						Resource res= resourceSet.getResource(URI.createFileURI(path), true);
						if (res != null) {
							resources.add(res);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return resources;
	}
	
	/**
	 * Collect IResources of type IFile. If the given resource is of type IFile,
	 * it is added to the collection. if it is of type IContainer (i.e. IProject, IFolder),
	 * the method is applied recursively on its children.
	 *  
	 * @param resource	the root resource
	 * @param extension	some file extension or null, if the extension doesn't matter
	 * @return			list of IFiles under <code>resource</code> with extension <code>extension</code>
	 * @generated NOT
	 */
	private static List<IResource> getLeafMembers(IResource resource, String extension) {
		List<IResource> resources= new ArrayList<IResource>();
		if (resource instanceof IFile) {
			if (extension == null || extension.equals(resource.getFileExtension()) ) {
				resources.add(resource);	
			}
		}
		if (resource instanceof IContainer) {
			IContainer container= (IContainer) resource;
			try {
				for (IResource member : container.members()) {
					resources.addAll(getLeafMembers(member, extension));
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return resources;
	}

}
