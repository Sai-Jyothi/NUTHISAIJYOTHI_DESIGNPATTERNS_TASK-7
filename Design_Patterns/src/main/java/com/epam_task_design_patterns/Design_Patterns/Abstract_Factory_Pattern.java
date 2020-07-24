package com.epam_task_design_patterns.Design_Patterns;

import java.io.*;    
interface Bank{  
        String getBankName();  
}  
class  HSBC implements Bank{  
         private final String BNAME;  
         public HSBC(){  
                BNAME="HSBC BANK";  
        }  
        public String getBankName() {  
                  return BNAME;  
        }  
}  
class BARODA implements Bank{  
       private final String BNAME;  
       BARODA(){  
                BNAME="BARODA BANK";  
        }  
        public String getBankName() {  
                  return BNAME;  
       }  
}  
class SBI implements Bank{  
      private final String BNAME;  
      public SBI(){  
                BNAME="SBI BANK";  
        }  
       public String getBankName(){  
                  return BNAME;  
       }  
}  

abstract class Loan{  
   protected double rate;  
   abstract void getInterestRate(double rate);  
   public void calculateLoanPayment(double loanamount, int years)  
   {      double EMI;  
         int n;  
 
         n=years*12;  
         rate=rate/1200;  
         EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;  
 
System.out.println("Your monthly EMI is : "+ EMI +" for the loan amount :- "+loanamount+"  you have borrowed");    
 }  
}

class HomeLoan extends Loan{  
     public void getInterestRate(double r){  
         rate=r;  
    }  
}  
class BussinessLoan extends Loan{  
    public void getInterestRate(double r){  
          rate=r;  
     }  
 
}
class EducationLoan extends Loan{  
     public void getInterestRate(double r){  
       rate=r;  
 }  
}


abstract class AbstractFactory{  
  public abstract Bank getBank(String bank);  
  public abstract Loan getLoan(String loan);  
}  


class BankFactory extends AbstractFactory{  
   public Bank getBank(String bank){  
      if(bank == null){  
         return null;  
      }  
      if(bank.equalsIgnoreCase("HSBC")){  
         return new HSBC();  
      } else if(bank.equalsIgnoreCase("BARODA")){  
         return new BARODA();  
      } else if(bank.equalsIgnoreCase("SBI")){  
         return new SBI();  
      }  
      return null;  
   }  
  public Loan getLoan(String loan) {  
      return null;  
   }  
}
class LoanFactory extends AbstractFactory{  
           public Bank getBank(String bank){  
                return null;  
          }  
       
     public Loan getLoan(String loan){  
      if(loan == null){  
         return null;  
      }  
      if(loan.equalsIgnoreCase("Home")){  
         return new HomeLoan();  
      } else if(loan.equalsIgnoreCase("Business")){  
         return new BussinessLoan();  
      } else if(loan.equalsIgnoreCase("Education")){  
         return new EducationLoan();  
      }  
      return null;  
   }  
     
}  

class FactoryCreator {  
     public static AbstractFactory getFactory(String choice){  
      if(choice.equalsIgnoreCase("Bank")){  
         return new BankFactory();  
      } else if(choice.equalsIgnoreCase("Loan")){  
         return new LoanFactory();  
      }  
      return null;  
   }  
}

class Abstract_Factory_Pattern {  
      public static void main(String args[])throws IOException {  
       
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
 
      System.out.println("Enter the name of the  Bank from where you want to take the loan amount : ");  
      String bankName=br.readLine();  
 
      System.out.println("Enter the type of loan i.e.; Home loan or Business loan or Education loan : ");  
 
      String loanName=br.readLine();  
      AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");  
      Bank b=bankFactory.getBank(bankName);  
 
      System.out.println("Enter the interest rate for "+b.getBankName()+ ": ");  
 
      double rate=Double.parseDouble(br.readLine());  
      System.out.println("Enter the loan amount you want to take : ");  
 
      double loanAmount=Double.parseDouble(br.readLine());  
      System.out.println("Enter the number of years to pay entire loan amount: ");  
      int years=Integer.parseInt(br.readLine());  
      System.out.println("You are taking the loan from : "+ b.getBankName());  
      AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");  
           Loan l=loanFactory.getLoan(loanName);  
           l.getInterestRate(rate);  
           l.calculateLoanPayment(loanAmount,years);  
  } 
}





/*OUTPUT:
 Enter the name of the  Bank from where you want to take the loan amount : 
HSBC
Enter the type of loan i.e.; Home loan or Business loan or Education loan : 
Home
Enter the interest rate for HSBC BANK: 
15
Enter the loan amount you want to take : 
1500
Enter the number of years to pay entire loan amount: 
3
You are taking the loan from : HSBC BANK
Your monthly EMI is : 51.99799275629133 for the loan amount :- 1500.0  you have borrowed

 */
