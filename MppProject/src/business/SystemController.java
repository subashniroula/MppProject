package business;

import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController extends Application implements ControllerInterface {
	public static Auth currentAuth = null;
	public static Stage stageArea;
	
	@Override
	public Auth login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Passord does not match password on record");
		}
		currentAuth = map.get(id).getAuthorization();
		return currentAuth;
	}
	/**
	 * This method checks if memberId already exists -- if so, it cannot be
	 * added as a new member, and an exception is thrown.
	 * If new, creates a new LibraryMember based on 
	 * input data and uses DataAccess to store it.
	 * 
	 */
//	public void addNewMember(String memberId, String firstName, String lastName,
//			String telNumber, Address addr) throws LibrarySystemException {
		
	
	/**
	 * Reads data store for a library member with specified id.
	 * Ids begin at 1001...
	 * Returns a LibraryMember if found, null otherwise
	 * 
	 */
	//public LibraryMember search(String memberId) {
	
	
	/**
	 * Same as creating a new member (because of how data is stored)
	 */
//	public void updateMemberInfo(String memberId, String firstName, String lastName,

	
	/**
	 * Looks up Book by isbn from data store. If not found, an exception is thrown.
	 * If no copies are available for checkout, an exception is thrown.
	 * If found and a copy is available, member's checkout record is
	 * updated and copy of this publication is set to "not available"
	 */
	//public void checkoutBook(String memberId, String isbn) throws LibrarySystemException {
		
	@Override
	public Book searchBook(String isbn) {
		DataAccess da = new DataAccessFacade();
		return da.searchBook(isbn);
	}
	
	
	
	
	/**
	 * Looks up book by isbn to see if it exists, throw exceptioni.
	 * Else add the book to storage
	 */
//	public boolean addBook(String isbn, String title, int maxCheckoutLength, List<Author> authors) 
//			throws LibrarySystemException {
		
	
	public boolean addBookCopy(String isbn) throws LibrarySystemException {
		Book book = searchBook(isbn);
		if(book == null) throw new LibrarySystemException("No book with isbn " + isbn 
			+ " is in the library collection!");
		book.addCopy();
		return true;
	}

	 public static void main(String[] args) {
	        Application.launch(SystemController.class, args);
	    }
	@Override
	public void start(Stage stage) throws Exception {
			stageArea=stage;   
			Parent root = FXMLLoader.load(getClass().getResource("..\\View\\Login.fxml"));
	        stage.setTitle("Library Management System");
	        stage.setScene(new Scene(root, 500, 400));
	        stage.show();
    }
	@Override
	public void checkoutBook(String memberId, String isbn)
			throws LibrarySystemException {
		// TODO Auto-generated method stub
		
	}
}
