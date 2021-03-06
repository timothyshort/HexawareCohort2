package basics;

public class Shortcuts {
	/*
	.get() and .navigate().to()
	 .get() - start a new session
	 .navigate(). - typical browser actions (refresh, back/forward, change URL)
	 
	.close() and .quit()
	 .close() - closes the window
	 .quit() - destroys the WebDriver instance
	 
	java & variable definition
	 declaration (String firstName)
	 definition (firstName = "Steve")
	 declare + define in same line (String firstName = "Steve")
	 
	Polymorphism for Interfaces
	 WebDriver driver = new ChromeDriver()
	 WebDriver driver = new FirefoxDriver()
	  *ChromeDriver and FirefoxDriver BOTH implement the SAME WebDriver interface
	  *Therefore, both CD and FD have the same method/function NAMES but DIFFERENT implementation for the specific browser
	  *WebDriver .get() will open a new browser on Firefox or Chrome depending on where WebDriver points
	
	Polymorphism & Overloading
	 Java will NOT allow same function definition (name + argument)
	 Java WILL allow same function name with different argument
	
	Static vs Instance
	 Static - we can call directly without instantiation (uses functions)
	 Instance - we create a new, independent object with its distinct properties (uses methods)
	 
	Browsers: LinkText & Formatting
	 Chrome and IE interpret text post-CSS
	 Firefox interprets text from inner HTML
	 
	Programming Fundamentals
	 Variables - placeholders for data
	 Functions - declared, repeatable, callable code blocks that do work based on input
	 Arrays - ordered data by variable type (String, int) and logical category
	 Loops - repeated same code over again based on condition (While-loop, For-loop) 
	 Control Flow (if statements) - execute different code based on condition
	
	Constructors
	 1. is a public function defined as the same name as the class
	 2. has no return type (no void, no value)
	 3. is implicitly called when a new object is created
	 
	Data Structures
	 Arrays are primitive; size is fixed; index-based
	 Collections framework allows dynamic data handling (via series of methods)
	 
	Logic Statements (Switch)
	 Switch is used to test EQUIVALENCE of ONE variable
	 Switch "falls through" - one matching case, all following cases will execute (use break; to exit)
	 
	Selenium Waits
	 Implicitly Wait - default time that a WebDriver instance will wait for an element to appear before throwing an exception
	 Explicitly Wait - defined specifically for a specific element with defined conditions
	 
	Standard Naming Conventions
	 Class Names: Capitalize first letter of each word (LoginTestDemo)
	 Functions: lowercase first letter of first word, uppercase letter for subsequent words (printPageTitle)
	 Variables: same as functions (firstName)
	 Objects: similar to variables OR precede with o followed object/class name
	 
	*/
	
}
