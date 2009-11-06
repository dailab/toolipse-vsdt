<table> <tr> <td colspan=2> New Energy Saving Rule deployed. Shall the rule be started now? </td> </tr> <tr>
<td id='notMes1' MCFocusable='true' class='notificationButton' onclick="callURL(''); if (document.getElementsByName('CloseButtonNotification').length > 0) { var tmp = new Object(); tmp.type='click'; document.getElementsByName('CloseButtonNotification')[0].onclick(tmp) } ">YES</td>
<td id='notMes2' MCFocusable='true' class='notificationButton' onclick="             if (document.getElementsByName('CloseButtonNotification').length > 0) { var tmp = new Object(); tmp.type='click'; document.getElementsByName('CloseButtonNotification')[0].onclick(tmp) } ">NO</td>
</tr></table>



callURL('');
if (document.getElementsByName('CloseButtonNotification').length > 0) { 
	var tmp = new Object(); 
	tmp.type='click'; 
	document.getElementsByName('CloseButtonNotification')[0].onclick(tmp) 
}

if (document.getElementsByName('CloseButtonNotification').length > 0) { 
	document.getElementsByName('CloseButtonNotification')[0].fireIdEvent('click', document.getElementsByName('CloseButtonNotification')[0])
}