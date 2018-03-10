package org.denny.spring.tx.entity;

public class BookStock implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private String bookId ;
	
	private String bookStock ;

	public final String getBookId() {
		return bookId;
	}

	public final void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public final String getBookStock() {
		return bookStock;
	}

	public final void setBookStock(String bookStock) {
		this.bookStock = bookStock;
	}

	public BookStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookStock(String bookId, String bookStock) {
		super();
		this.bookId = bookId;
		this.bookStock = bookStock;
	}

	@Override
	public String toString() {
		return "BookStock [bookId=" + bookId + ", bookStock=" + bookStock + "]";
	}
	
	
}
