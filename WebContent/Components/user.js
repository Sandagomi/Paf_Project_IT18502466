// hide the divisions used to show the status messages on the page load
$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide(); 
}); 

//Save button 
$(document).on("click", "#btnSave", function(event)
{
	// Clear status msgesx
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
		 
	// Form validation
	var status = validateUserForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	// If valid
	//$("#formPayment").submit();
	var type = ($("#hiduserIdSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
			{
			 url : "usersAPI",
			 type : type,
			 data : $("#formUser").serialize(),
			 dataType : "text",
			 complete : function(response, status)
			 {
				 onUsersSaveComplete(response.responseText, status);
			 }
			});
});

function onUsersSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divusersGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hiduserIdSave").val("");
	$("#formUser")[0].reset(); 
}

//CLIENTMODEL
function validateUserForm()
{
	//if ($("#userId").val().trim() == "")
	//{
	//	return "Insert userId";
	//}

	if ($("#firstName").val().trim() == "")
	{
		return "firstName";
	} 
	if ($("#lastName").val().trim() == "")
	{
		return "Insert lastName";
	}
	if ($("#userAddress").val().trim() == "")
	{
		return "Insert userAddress ";
	}
	
	if ($("#contactNumber").val().trim() == "")
	{
		return "Insert contactNumber";
	}
	if ($("#userDOB").val().trim() == "")
	{
		return "Insert userDOB";
	}
	if ($("#userAge").val().trim() == "")
	{
		return "Insert userAge";
	}
	if ($("#userEmail").val().trim() == "")
	{
		return "Insert userEmail";
	}

	return true;
}

//update button
$(document).on("click", ".btnUpdate", function(event)
{
	
	$("#hiduserIdSave").val($(this).closest("tr").find('#hiduserIdUpdate').val());
	//$("#userId").val($(this).closest("tr").find('td:eq(0)').text());
	$("#firstName").val($(this).closest("tr").find('td:eq(0)').text());
	$("#lastName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#userAddress").val($(this).closest("tr").find('td:eq(2)').text());
	$("#contactNumber").val($(this).closest("tr").find('td:eq(3)').text());
	$("#userDOB").val($(this).closest("tr").find('td:eq(4)').text());
	$("#userAge").val($(this).closest("tr").find('td:eq(5)').text());
	$("#userEmail").val($(this).closest("tr").find('td:eq(6)').text());

});

//DELETE
$(document).on("click", ".btnRemove", function(event) {  
	
	$.ajax(  {   
		
		url : "usersAPI",   
		type : "DELETE",   
		data : "userId=" + $(this).data("userid"),   
		dataType : "text",   
		complete : function(response, status)   {    
			onUsersDeleteComplete(response.responseText, status);   
			
		}  
	}); 
	
}); 

function onUsersDeleteComplete(response, status) {  
	
	if (status == "success")  {   
		
		var resultSet = JSON.parse(response); 

			if (resultSet.status.trim() == "success")   {    
				
				$("#alertSuccess").text("Successfully deleted.");    
				$("#alertSuccess").show(); 
				$("#divusersGrid").html(resultSet.data);   
				
			} else if (resultSet.status.trim() == "error")   {    
				
				$("#alertError").text(resultSet.data);    
				$("#alertError").show();   
				
			} 

	} else if (status == "error")  {   
		
		$("#alertError").text("Error while deleting.");   
		$("#alertError").show();  
		
	} else  {   
		
		$("#alertError").text("Unknown error while deleting..");   
		$("#alertError").show();  
		
	} 
	
}
