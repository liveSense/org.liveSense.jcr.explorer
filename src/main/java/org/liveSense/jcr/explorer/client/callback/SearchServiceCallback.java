package org.liveSense.jcr.explorer.client.callback;

import java.util.List;

import org.liveSense.jcr.explorer.client.JcrExplorer;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * 
 * @author James Pickup
 *
 */
public class SearchServiceCallback implements AsyncCallback<List<String>> {
	private JcrExplorer jackrabbitExplorer;
	public SearchServiceCallback(JcrExplorer jackrabbitExplorer) {
		this.jackrabbitExplorer = jackrabbitExplorer;
	}
	public void onSuccess(List<String> result) {
		List<String> returnList = result;

		if (null == returnList || returnList.size() < 1) {
			SC.say("No results for search.");
			JcrExplorer.hideLoadingImg();
			return;
		}
		ListGridRecord[] searchResultsListGridRecords = new ListGridRecord[]{};
		searchResultsListGridRecords = new ListGridRecord[returnList.size()];
		int i = 0;
		for (String resultString : returnList) {
			ListGridRecord listGridRecord = new ListGridRecord();
	        listGridRecord.setAttribute("path", resultString);
			searchResultsListGridRecords[i] = listGridRecord;
			i++;
		}
		jackrabbitExplorer.searchResultsListGrid.setData(searchResultsListGridRecords);
		
		jackrabbitExplorer.bottomRightTabSet.selectTab(1);
		JcrExplorer.hideLoadingImg();
	}

	public void onFailure(Throwable caught) {
		SC.warn("There was an error: " + caught.toString(), new NewBooleanCallback());
		JcrExplorer.hideLoadingImg();
	}
}

