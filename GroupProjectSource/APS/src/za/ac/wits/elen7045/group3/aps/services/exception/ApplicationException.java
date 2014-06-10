
package za.ac.wits.elen7045.group3.aps.services.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static <T> T checkedException (Throwable t) throws ApplicationException{
		return ApplicationException.<T>checkedException(t.getMessage(),t);
	}	

   public static <T> T checkedException (String message,Throwable t) throws ApplicationException{
	  if (t instanceof Error) throw (Error) t;
	  if (t instanceof RuntimeException) throw (RuntimeException) t;
	  if (t instanceof ApplicationException) throw (ApplicationException) t;
      throw (ApplicationException) new ApplicationException(message).initCause(t);
   }
   
   List <String> messages = null;
      
   /**
    * Creates new <code>GeneralException</code> without detail message.
    */
   public ApplicationException() {
       super();
   }

   /**
    * Constructs an <code>GeneralException</code> with the specified detail message.
    * @param msg the detail message.
    */
   public ApplicationException(String msg) {
       super(msg);
   }

   /**
    * Constructs an <code>GeneralException</code> with the specified detail message and nested Exception.
    * @param msg the detail message.
    * @param nested the nested exception.
    */
   public ApplicationException(String msg, Throwable nested) {
       super(msg, nested);
   }

   /**
    * Constructs an <code>GeneralException</code> with the specified detail message and nested Exception.
    * @param nested the nested exception.
    */
   public ApplicationException(Throwable nested) {
       super(nested);
   }

   /**
    * Constructs an <code>GeneralException</code> with the specified detail message, list and nested Exception.
    * @param msg the detail message.
    * @param messages error message list.
    */
   public ApplicationException(String msg, List<String> messages) {
       super(msg);
       this.messages = messages;
   }

   /**
    * Constructs an <code>GeneralException</code> with the specified detail message, list and nested Exception.
    * @param msg the detail message.
    * @param messages error message list.
    * @param nested the nexted exception
    */
   public ApplicationException(String msg, List<String> messages, Throwable nested) {
       super(msg, nested);
       this.messages = messages;
   }

   /**
    * Constructs an <code>GeneralException</code> with the specified detail message list and nested Exception.
    * @param messages error message list.
    * @param nested the nested exception.
    */
   public ApplicationException(List<String> messages, Throwable nested) {
       super(nested);
       this.messages = messages;
   }

   public ApplicationException(List<String> messages) {
       super();
       this.messages = messages;
   }

   /** Returns the detail message, including the message from the nested exception if there is one. */
   @Override
   public String getMessage() {
       Throwable nested = getCause();
       if (nested != null) {
           if (super.getMessage() == null) {
               return nested.getMessage();
           } else {
               return super.getMessage() + " (" + nested.getMessage() + ")";
           }
       } else {
           return super.getMessage();
       }
   }

   public List<String> getMessageList() {
       return this.messages;
   }

   /** Returns the detail message, NOT including the message from the nested exception. */
   public String getNonNestedMessage() {
       return super.getMessage();
   }

   /** Returns the nested exception if there is one, null if there is not. */
   public Throwable getNested() {
       Throwable nested = getCause();
       if (nested == null) {
           return this;
       }
       return nested;
   }

   /** Prints the composite message to System.err. */
   @Override
   public void printStackTrace() {
       super.printStackTrace();
   }

   /** Prints the composite message and the embedded stack trace to the specified stream ps. */
   
   public void printStackTrace(PrintStream ps) {
       super.printStackTrace(ps);
   }

   /** Prints the composite message and the embedded stack trace to the specified print writer pw. */
   
   public void printStackTrace(PrintWriter pw) {
       super.printStackTrace(pw);
   }

}
