package za.co.kanban.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.kanban.dtos.KanbanRow;
import za.co.kanban.dtos.SubtaskKanbanItemDto;
import za.co.kanban.model.SubtaskKanbanItem;
import za.co.kanban.modules.SubtaskModule;

public class KanbanRowsMaker {
	private static final Logger log = LoggerFactory.getLogger(KanbanRowsMaker.class);
	

	public static List<KanbanRow> makeKanbanRows(
			List<SubtaskKanbanItem> subtaskColumn1Items,
			List<SubtaskKanbanItem> subtaskColumn2Items, 
			List<SubtaskKanbanItem> subtaskColumn3Items,
			List<SubtaskKanbanItem> subtaskColumn4Items, 
			List<SubtaskKanbanItem> subtaskColumn5Items,
			List<SubtaskKanbanItem> subtaskColumn6Items) {	
		if(subtaskColumn1Items!=null&&! subtaskColumn1Items.isEmpty()) {
			displayInLog(subtaskColumn1Items.get(0));
		}

		List<SubtaskKanbanItemDto> column1Items=makeSubtaskKanbanItemDto(subtaskColumn1Items);
		List<SubtaskKanbanItemDto> column2Items=makeSubtaskKanbanItemDto(subtaskColumn2Items); 
		List<SubtaskKanbanItemDto> column3Items=makeSubtaskKanbanItemDto(subtaskColumn3Items);
		List<SubtaskKanbanItemDto> column4Items=makeSubtaskKanbanItemDto(subtaskColumn4Items); 
		List<SubtaskKanbanItemDto> column5Items=makeSubtaskKanbanItemDto(subtaskColumn5Items);
		List<SubtaskKanbanItemDto> column6Items=makeSubtaskKanbanItemDto(subtaskColumn6Items); 
	
		return makeKanbanRowsFromDTOs(column1Items,column2Items,column3Items,
				column4Items,column5Items,column6Items);
	}
	
	public static List<KanbanRow> makeKanbanRowsFromDTOs(
			List<SubtaskKanbanItemDto> subtaskColumn1Items,
			List<SubtaskKanbanItemDto> subtaskColumn2Items, 
			List<SubtaskKanbanItemDto> subtaskColumn3Items,
			List<SubtaskKanbanItemDto> subtaskColumn4Items, 
			List<SubtaskKanbanItemDto> subtaskColumn5Items,
			List<SubtaskKanbanItemDto> subtaskColumn6Items) {
		
		List<KanbanRow> kanbanRows=new ArrayList<>();
		int maximumArrayLength=getMaximumArrayLength(subtaskColumn1Items,subtaskColumn2Items, 
				subtaskColumn3Items,subtaskColumn4Items, subtaskColumn5Items, subtaskColumn6Items);
		
		KanbanRow[] KanbanRowArray=new KanbanRow[maximumArrayLength];
		
		for(int i=0;i<maximumArrayLength;i++) {
			KanbanRow kanbanRow=new KanbanRow();
			KanbanRowArray[i]=kanbanRow;
		}
		
		int loopcounter=0;
		if(subtaskColumn1Items!=null && ! subtaskColumn1Items.isEmpty()) {
			for(SubtaskKanbanItemDto rowItem: subtaskColumn1Items) {
				String column =makeColumn(rowItem);
				KanbanRowArray[loopcounter].setColumn1(column );
				loopcounter++;
			}
		}
		
		loopcounter=0;
		if(subtaskColumn2Items!=null && ! subtaskColumn2Items.isEmpty()) {
			for(SubtaskKanbanItemDto rowItem: subtaskColumn2Items) {
				String column =makeColumn(rowItem);
				KanbanRowArray[loopcounter].setColumn2(column );
				loopcounter++;
			}
		}
		
		loopcounter=0;
		if(subtaskColumn3Items!=null && ! subtaskColumn3Items.isEmpty()) {
			for(SubtaskKanbanItemDto rowItem: subtaskColumn3Items) {
				String column =makeColumn(rowItem);
				KanbanRowArray[loopcounter].setColumn3(column );
				loopcounter++;
			}
		}
		
		loopcounter=0;
		if(subtaskColumn4Items!=null && ! subtaskColumn4Items.isEmpty()) {
			for(SubtaskKanbanItemDto rowItem: subtaskColumn4Items) {
				String column =makeColumn(rowItem);
				KanbanRowArray[loopcounter].setColumn4(column );
				loopcounter++;
			}
		}
		
		loopcounter=0;
		if(subtaskColumn5Items!=null && ! subtaskColumn5Items.isEmpty()) {
			for(SubtaskKanbanItemDto rowItem: subtaskColumn5Items) {
				String column =makeColumn(rowItem);
				KanbanRowArray[loopcounter].setColumn5(column );
				loopcounter++;
			}
		}
		
		loopcounter=0;
		if(subtaskColumn6Items!=null && ! subtaskColumn6Items.isEmpty()) {
			for(SubtaskKanbanItemDto rowItem: subtaskColumn6Items) {
				String column =makeColumn(rowItem);
				KanbanRowArray[loopcounter].setColumn6(column );
				loopcounter++;
			}
		}
		
		for(KanbanRow row : KanbanRowArray) {
			if(row!=null) {
				kanbanRows.add(row);
			}
		}
		

		return kanbanRows;
	}
	
	private static String makeColumn(SubtaskKanbanItemDto rowItem) {
		String column=null;
		if(StringUtils.isNotEmpty(rowItem.getAssignedTo())){
			column=rowItem.getAssignedTo().toUpperCase()
			+" : "+rowItem.getDescription();
		} else {
			column="Not assigned : "+rowItem.getDescription();
			
		}
//		+"<br/> Task: "+rowItem.getTaskName()+"<br/> Due Date: "+rowItem.getDueDate()+"<hr>";
	
		return column;
	}

	static int getMaximumArrayLength(List<SubtaskKanbanItemDto> subtaskColumn1Items,
			List<SubtaskKanbanItemDto> subtaskColumn2Items, List<SubtaskKanbanItemDto> subtaskColumn3Items,
			List<SubtaskKanbanItemDto> subtaskColumn4Items, List<SubtaskKanbanItemDto> subtaskColumn5Items,
			List<SubtaskKanbanItemDto> subtaskColumn6Items) {
		
		int maximumArrayLength=0;
		if(subtaskColumn1Items!=null && subtaskColumn1Items.size()>maximumArrayLength) {
			maximumArrayLength=subtaskColumn1Items.size();
		}
		if(subtaskColumn2Items!=null && subtaskColumn2Items.size()>maximumArrayLength) {
			maximumArrayLength=subtaskColumn2Items.size();
		}
		if(subtaskColumn3Items!=null && subtaskColumn3Items.size()>maximumArrayLength) {
			maximumArrayLength=subtaskColumn3Items.size();
		}
		if(subtaskColumn4Items!=null && subtaskColumn4Items.size()>maximumArrayLength) {
			maximumArrayLength=subtaskColumn4Items.size();
		}
		if(subtaskColumn5Items!=null && subtaskColumn5Items.size()>maximumArrayLength) {
			maximumArrayLength=subtaskColumn5Items.size();
		}
		if(subtaskColumn6Items!=null && subtaskColumn6Items.size()>maximumArrayLength) {
			maximumArrayLength=subtaskColumn6Items.size();
		}
		
		return maximumArrayLength;
	}



	private static List<SubtaskKanbanItemDto> makeSubtaskKanbanItemDto(List<SubtaskKanbanItem> subtaskColumn1Items) {
		List<SubtaskKanbanItemDto> subtaskKanbanItemDtos=new ArrayList<>();
		if(subtaskColumn1Items!=null && ! subtaskColumn1Items.isEmpty()) {
			for (SubtaskKanbanItem subtaskKanbanItem : subtaskColumn1Items) {
				if(subtaskKanbanItem!=null) {
					SubtaskKanbanItemDto dto=new SubtaskKanbanItemDto();
					dto.setAssignedTo(subtaskKanbanItem.getAssignee());
					dto.setDescription(subtaskKanbanItem.getDescription());
					String dueDate=Utils.dateToString(subtaskKanbanItem.getDate());
					dto.setDueDate(dueDate);
					String subtaksId = ""+subtaskKanbanItem.getId();
					dto.setsSubtaskId(subtaksId);
					dto.setStatus(subtaskKanbanItem.getStatus());
					dto.setSubtaskName(subtaskKanbanItem.getName());
					dto.setTaskName(subtaskKanbanItem.getTaskName());
					subtaskKanbanItemDtos.add(dto);
				}
			}
		}
		return subtaskKanbanItemDtos;
	}

	

	private static void displayInLog(SubtaskKanbanItem subtaskKanbanItem) {
		if(subtaskKanbanItem!=null) {
			String status=subtaskKanbanItem.getStatus();
			Long subtaskId = subtaskKanbanItem.getId();
			String subtaskName=subtaskKanbanItem.getName();
			String description=subtaskKanbanItem.getDescription();
			String taskName=subtaskKanbanItem.getTaskName();
			String assignedTo=subtaskKanbanItem.getAssignee();
			Date dueDate = subtaskKanbanItem.getDate();	
			System.out.println(subtaskKanbanItem.getAssignee());
	
			log.info("KANBAN : KanbanRowsMaker : displayInLog : subtaskKanbanItem : [ "+
					"status:"+status+
					",subtaskId:"+subtaskId+
					",subtaskName:"+subtaskName+
					",description:"+description+
					",taskName:"+taskName+
					",assignedTo:"+assignedTo+
					",dueDate:"+dueDate+				
					" ]");	
					
		}
	}
}
