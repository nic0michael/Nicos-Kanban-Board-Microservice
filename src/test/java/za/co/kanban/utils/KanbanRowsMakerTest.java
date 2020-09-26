package za.co.kanban.utils;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.kanban.dtos.KanbanRow;
import za.co.kanban.dtos.SubtaskKanbanItemDto;

@RunWith(SpringRunner.class)
public class KanbanRowsMakerTest {
	

	@Test
	public void makeKanbanRowsFromDTOsTest() {
		List<SubtaskKanbanItemDto> subtaskColumn1Items=getSubtaskColumnItems(1);
		List<SubtaskKanbanItemDto> subtaskColumn2Items=getSubtaskColumnItems(2);
		List<SubtaskKanbanItemDto> subtaskColumn3Items=getSubtaskColumnItems(3);
		List<SubtaskKanbanItemDto> subtaskColumn4Items=getSubtaskColumnItems(4);
		List<SubtaskKanbanItemDto> subtaskColumn5Items=getSubtaskColumnItems(5);
		List<SubtaskKanbanItemDto> subtaskColumn6Items=getSubtaskColumnItems(6);
		List<KanbanRow> kanbanRows=KanbanRowsMaker.makeKanbanRowsFromDTOs(subtaskColumn1Items,subtaskColumn2Items,
				subtaskColumn3Items,subtaskColumn4Items,subtaskColumn5Items,subtaskColumn6Items);

		assertThat( kanbanRows,is(notNullValue()));
		System.out.println("Size: "+kanbanRows.size());
	
	}

	private List<SubtaskKanbanItemDto> getSubtaskColumnItems(int columnNr) {

		List<SubtaskKanbanItemDto> subtaskKanbanItems= new ArrayList<>();
		for(int i=0;i<5;i++) {
			SubtaskKanbanItemDto dto=new SubtaskKanbanItemDto();
			
			dto.setAssignedTo("Mr Tee "+i);
			dto.setDueDate("12 March 2020");
			dto.setsSubtaskId("00"+columnNr+"00"+i);
			dto.setSubtaskName("A small thing "+columnNr+"_"+i);
			dto.setTaskName("A big thing"+columnNr+"_"+i);
			dto.setStatus(""+columnNr+"_"+i+" status");
			subtaskKanbanItems.add(dto);
		}
		
		return subtaskKanbanItems;
	}

}
