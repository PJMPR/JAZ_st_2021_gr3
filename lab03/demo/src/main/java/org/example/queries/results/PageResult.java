package org.example.queries.results;

import org.example.queries.search.Page;

public class PageResult {

	private final Results results;

	public PageResult(Results results) {
		this.results = results;

	}

	public void pageResult(Page page) {
		if (page != null) {
			int indexStart = Math.min(page.getSize() * (page.getPageNumber() - 1), results.getItems().size());
			int indexStop = Math.min(page.getSize() * page.getPageNumber(), results.getItems().size());

			results.setItems(results.getItems().subList(indexStart, indexStop));

			results.setCurrentPage(page.getPageNumber());
			results.setPages((int) Math.ceil((double) results.getItems().size() / page.getSize()));
		}
	}
}
