package org.ngrinder.perftest.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.ngrinder.monitor.controller.model.SystemDataModel;
import org.python.google.common.collect.Lists;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MonitorCollectorTest {

	@Test
	public void testMonitor() {
		SystemDataModel systemDataModel = new SystemDataModel();
		systemDataModel.setCollectTime(100);
		systemDataModel.setFreeMemory(20);
		systemDataModel.setCpuUsedPercentage(20);
		List<SystemDataModel> lists = Lists.newArrayList();
		lists.add(systemDataModel);
		lists.add(systemDataModel);
		Gson gson = new Gson();
		String json = gson.toJson(lists);
		ArrayList<SystemDataModel> fromJson = gson.fromJson(json, getTypeToken());
		System.out.println(fromJson.get(0).getClass());
	}

	private Type getTypeToken() {
		return new TypeToken<ArrayList<SystemDataModel>>() {
			private static final long serialVersionUID = 1L;
		}.getType();
	}
}
