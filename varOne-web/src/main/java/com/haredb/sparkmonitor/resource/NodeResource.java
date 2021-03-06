/**
 * 
 */
package com.haredb.sparkmonitor.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.haredb.sparkmonitor.facade.SparkMonitorFacade;
import com.haredb.sparkmonitor.vo.DefaultNodeVO;

/**
 * @author allen
 *
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("/nodes")
public class NodeResource {
	
	@GET
	@Path("/")
	public String fetchNodes() throws Exception{
		SparkMonitorFacade facade = new SparkMonitorFacade();
		List<String> nodes = facade.getNodeLists();
		Gson gson = new Gson();
		return gson.toJson(nodes);
	}
	
	@GET
	@Path("/{node}")
	public String fetchNodeDashBoard(@PathParam("node") String node, @QueryParam("metrics") String metrics) throws Exception{
		SparkMonitorFacade facade = new SparkMonitorFacade();
		List<String> metricsAsList = new ArrayList<String>();
		if(metrics != null){
			String[] metricsArr = metrics.split(",");
			for(String metric: metricsArr){
				if(!metric.trim().equals(""))
					metricsAsList.add(metric);
			}
		}
		DefaultNodeVO nodeDashBoard = facade.getNodeDashBoard(node, metricsAsList);
		Gson gson = new Gson();
		return gson.toJson(nodeDashBoard);
	}
}
