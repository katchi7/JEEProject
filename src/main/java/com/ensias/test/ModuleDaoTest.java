package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import com.ensias.beans.User;
import com.ensias.dao.DAOUser;
import com.ensias.dao.ModuleDao;
import com.ensias.beans.Module;
import com.ensias.beans.Document;

class ModuleDaoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindModuleById() {
		ModuleDao module= Mockito.mock(ModuleDao.class);
		Module sampleModule = new Module();
		sampleModule.setElm_id(0);
        when(module.findModuleById(0)).thenReturn(sampleModule);
        assertEquals(0,module.findModuleById(0).getElm_id());
	}
	@Test
	/*void testCreerModules() {
		
		ModuleDao module= Mockito.mock(ModuleDao.class);
		Module sampleModule = new Module();
		Module sampleModule1 = new Module();
		
		ArrayList<String> filieres = new ArrayList<String>();
		filieres.add("gl");
		List<Module> moduleMap = new ArrayList<>();
		when(module.creerModule(sampleModule, filieres)).thenAnswer(i -> {
		    Module module2 = i.getArgument(0);
		   moduleMap.add(module2., user1);
		    return null;
		});
		when(module.findModuleById(sampleModule1.getElm_id())).thenAnswer(i -> {
		    int id = i.getArgument(0);
		    return moduleMap.get(id);
		});
	}
	@Test
	void testCreateDocs() {
		
		ModuleDao module= Mockito.mock(ModuleDao.class);
		Module sampleModule = new Module();
		Module sampleModule1 = new Module();
	
		ArrayList<Document> docs = new ArrayList<>();
		Document doc1= new Document();
		List<ArrayList<Document>> moduleMap = new ArrayList<>();
		when(module.CreateDocs(docs)).thenAnswer(i -> {
		   Document doc = i.getArgument(0);
		   moduleMap.add(doc.getDoc_id(),sampleModule1);
		    return null;		});
		when(module.findModuleById(sampleModule1.getElm_id())).thenAnswer(i -> {
		    int id = i.getArgument(0);
		    return moduleMap.get(id);
		});
	}*/
	

}
