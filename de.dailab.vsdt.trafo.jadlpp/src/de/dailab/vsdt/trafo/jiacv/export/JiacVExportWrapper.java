package de.dailab.vsdt.trafo.jiacv.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.dailab.jiactng.jadl.Agent;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.impl.BpmnExportWrapper;
import de.dailab.vsdt.trafo.jiacv.util.Util;

/**
 * Maintains a mapping from resulting models back to the original pools.
 * 
 * @author kuester
 */
public class JiacVExportWrapper extends BpmnExportWrapper {

	private final Map<Agent, Pool> modelPoolMap;
	
	private final Map<Participant, List<JiacVStarterRule>> starterRules;
	
	private final List<Agent> jadlFiles;
	
//	private AgentWorld agentWorld;
	
	public JiacVExportWrapper(BusinessProcessSystem bps) {
		super(bps);
		modelPoolMap= new HashMap<Agent, Pool>();
		starterRules= new HashMap<Participant, List<JiacVStarterRule>>();
		jadlFiles= new ArrayList<Agent>();
	}

	@Override
	public void map(Object key, Object value) {
		super.map(key, value);
		if (key instanceof Pool && value instanceof Agent) {
			modelPoolMap.put((Agent) value, (Pool) key);
		}
	}
	
	public Pool getPool(Agent model) {
		return model != null ? modelPoolMap.get(model) : null;
	}
	
//	public void setAgentWorld(AgentWorld agentWorld) {
//		getTargetModels().add(agentWorld);
//		map(getSourceModel(), agentWorld);
//		this.agentWorld = agentWorld;
//	}
	
	public void addJadlFile(Agent agent, Pool pool) {
		map(pool, agent);
		getTargetModels().add(agent);
		modelPoolMap.put(agent, pool);
		jadlFiles.add(agent);
	}
	
	public List<Agent> getJadlFiles() {
		return jadlFiles;
	}
	
//	public AgentWorld getAgentWorld() {
//		return agentWorld;
//	}
	
	public Map<Participant, List<JiacVStarterRule>> getStarterRules() {
		return starterRules;
	}
	
	public void addStarterRule(Participant participant, JiacVStarterRule starterRule) {
		if (participant != null && starterRule != null) {
			List<JiacVStarterRule> rules= starterRules.get(participant);
			if (rules == null) {
				rules= new ArrayList<JiacVStarterRule>();
				starterRules.put(participant, rules);
			}
			rules.add(starterRule);
		}
	}

	public String getJadlFileName(Agent agent) {
		if (agent != null) {
			Pool pool= getPool(agent);
			if (pool != null) {
				String poolName= pool.getName();
				String bpdName= pool.getParent().getName();
				String roleName= pool.getParticipant().getName();
	
				StringBuffer buffer= new StringBuffer();
				buffer.append(JiacVResultSaver.groupByUsecase
						? ( bpdName + Util.FILE_SEP + roleName)
						: ( roleName + Util.FILE_SEP + bpdName));
				buffer.append("_").append(poolName);
				buffer.append(Util.EXT_JADL);
				return buffer.toString();
			}
		}
		return null;
	}
	
	public String getRulesFileName(Participant participant) {
		if (participant != null) {
			String roleName= participant.getName();
			
			StringBuffer buffer= new StringBuffer();
			buffer.append(JiacVResultSaver.groupByUsecase
					? ( roleName )
					: ( roleName + Util.FILE_SEP + roleName));
			buffer.append("_starterRules");
			buffer.append(Util.EXT_DROOLS);
			return buffer.toString();
		}
		return null;
	}
	
//	public String getAweFileName(AgentWorld agentWorld, boolean diagramFile) {
//		if (agentWorld != null) {
//			return agentWorld.getName() + (diagramFile ? Util.EXT_AWE_DIAGRAM : Util.EXT_AWE_MODEL);
//		} else {
//			return null;
//		}
//	}
}
