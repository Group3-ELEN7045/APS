package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.za.ac.wits.elen7045.group3.ebilling.tests.TestForProductsPresentation;
import test.za.ac.wits.elen7045.group3.register.tests.user.RegisterUserTest;
import test.za.ac.wits.elen7045.group3.security.test.TestUserLogon;
@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestUserLogon.class,
   RegisterUserTest.class,
   TestUserLogon.class,
   TestForProductsPresentation.class
})
public class PresentationSuite {   
}  	