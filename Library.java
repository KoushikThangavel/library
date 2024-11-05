
import java.io.*;
import java.util.*;
class BookStack
{
	String bookname,autherName;
	int bookid,price,bookCount;
	int bookCount2=0;
	ArrayList<String> lendstdname=new ArrayList<String>();
	boolean flagBook;
	BookStack(String bookname,String autherName,int price,int bookCount,int bookid,boolean flagBook)
	{
		this.bookname=bookname;
		this.autherName=autherName;
		this.price=price;
		this.bookCount=bookCount;
		this.bookid=bookid;
		this.flagBook=flagBook;
	}

}
class StudentStack
{
	String stdname,stdpassword,lendbook;
	int stdId;
	boolean flagstd,stdgetbook=false;
	StudentStack(String stdname,String stdpassword,int stdId,boolean flagstd)
	{
		this.stdname=stdname;
		this.stdpassword=stdpassword;
		this.stdId=stdId;
		this.flagstd=flagstd;
	}
}
class Main
{
	static int stdDemoId=1001,bookDemoId=2001;
	public static void main(String ar[])throws Exception
	{
		ArrayList<StudentStack> student=new ArrayList<StudentStack>();
		ArrayList<BookStack> book=new ArrayList<BookStack>();
		Scanner in=new Scanner(System.in);
		int n,m,o,i,f,j,k,removename;
		String aname,apass;
		while(true)
		{
			System.out.println("\t----------------------------------------------");
			System.out.println("\t\t\t Library Modul");
			System.out.println("\t----------------------------------------------");
			System.out.println("\t1.Admin\n\t2.Student\n\t3.Exit\n");
			n=in.nextInt();
			if(n==1)
			{
				//admin();
				System.out.print("Enter the Admin Name        : ");
				aname=in.next();
				System.out.print("Enter the Admin Password  : ");
				apass=in.next();
				if(aname.equals("Koushik")&&apass.equals("1111"))
				{
					System.out.println("\t----------------------------------------------");
					System.out.println("\t\t\t Librarian");
					System.out.println("\t----------------------------------------------");
					while(true)
					{
						String bname,auname;
						int pz,ct,hmb;
						System.out.println("\t1.AddBook\n\t2.IssuedBook\n\t3.Report\n\t4.Student details\n\t5.Logout\n");
						m=in.nextInt();
						if(m==1)
						{
							System.out.print("How many books added       : ");
							hmb=in.nextInt();
							for(i=1;i<=hmb;i++)
							{
								System.out.print("Enter the Book Name        : ");
								bname=in.next();
								System.out.print("Enter the Auther Name      : ");
								auname=in.next();
								System.out.print("Enter the Book Price       : ");
								pz=in.nextInt();
								System.out.print("Enter the Number of Boooks : ");
								ct=in.nextInt();
								System.out.printf("Book Id                   : %d\n\n",bookDemoId);
								book.add(new BookStack(bname,auname,pz,ct,bookDemoId,true));
								bookDemoId++;
							}
						}
						else if(m==2)
						{
							System.out.println("\nBookId\t\tBookPrice\tBookname\tAuherName\tBookissuedCount");
							for(BookStack b:book)
							{
								//if(b.flagBook!=false)
								System.out.printf("%-5d\t%-10s\t%-10s\t%-5d\t%-5d",b.bookid,b.bookname,b.autherName,b.price,b.bookCount2);
								System.out.println();
								System.out.println("Namelist");
								for(String s:b.lendstdname)
									System.out.println(s);
								System.out.println();
							}
							System.out.println();
						}
						else if(m==3)
						{
							try{
								FileWriter fle=new FileWriter("file01.txt");
								fle.write("BookId\tBookname\tAuherName\tBookPrice\tAvBookCount\tnotAvBookCount\n");
								System.out.println("\nBookId\tBookname\tAuherName\tBookPrice\tAvBookCount\tnotAvBookCount");
								for(BookStack b:book)
								{
									//if(b.flagBook=false)
									System.out.printf("%5d\t%10s\t%10s\t%5d\t%5d\t%5d",b.bookid,b.bookname,b.autherName,b.price,(b.bookCount-b.bookCount2),b.bookCount2);
									fle.write(b.bookid+"\t"+b.bookname+"\t"+b.autherName+"\t"+b.price+"\t"+(b.bookCount-b.bookCount2)+"\t"+b.bookCount2);
									System.out.println();
									fle.write("\n");
								}							
								fle.close();
								System.out.println("success");
							}
							catch(IOException e)
							{
								System.out.println("error");
								e.printStackTrace();
							}
							System.out.println();
						}
						else if(m==4)	
						{		System.out.println("\nstdId\tBookname\tstdName\tstdpassword\tlendBook");
								 for(StudentStack stddils:student)
								 {
								 		System.out.printf("%5d\t%10s\t%10s\t%5s",stddils.stdId,stddils.stdname,stddils.stdpassword,stddils.lendbook);
								 		System.out.println();
								 }
						}
						else if(m==5)
						{
							break;
						}
						else
							System.out.println("Wrong choice....");
					}
				}
				else
					System.out.println("Wrong Id or password....");
			}
			else if(n==2)
			{
				while(true)
				{
					System.out.println("\t1.SignUp\n\t2.Login\n\t3.Back\n");
					m=in.nextInt();
					if(m==1)
					{
						String sname,ps;
						System.out.println("\t----------------------------------------------");
						System.out.println("\t\t\t SignUp");
						System.out.println("\t----------------------------------------------");
						System.out.print("Enter the Student Name   : ");
						sname=in.next();
						System.out.print("Enter the Password       : ");
						ps=in.next();
						System.out.printf("Student Id              : %d\n",stdDemoId);
						student.add(new StudentStack(sname,ps,stdDemoId,true));
						stdDemoId++;
					}
					else if(m==2)
					{
						int stid,boid,f2;
						String stpass,boname;
						System.out.println("\t----------------------------------------------");
						System.out.println("\t\t\t LogIn");
						System.out.println("\t----------------------------------------------");
						System.out.print("Enter the Student Id           : ");
						stid=in.nextInt();
						System.out.print("Enter the Student Possword     : ");
						stpass=in.next();
						System.out.println();
						f=0;j=0;
						for(StudentStack a:student)
						{
							if(a.stdpassword.equals(stpass)&&a.stdId==stid)
							{
								f=1;
								while(true)
								{
									System.out.println("\n\t1.View Books\n\t2.Lend Book\n\t3.Return Book\n\t4.Logout\n");
									o=in.nextInt();
									if(o==1)
									{
										System.out.println("\nBookId\t\tBookPrice\tBookname\tAuherName\tAvBooks");
										for(BookStack b:book)
										{
											System.out.printf("%5d\t%10s\t%10s\t%5d\t%5d",b.bookid,b.bookname,b.autherName,b.price,(b.bookCount-b.bookCount2));
											System.out.println();
										}
										System.out.println();
									}
									else if(o==2)
									{
										if(a.stdgetbook==false)
										{
											System.out.print("Enter the BookId       : ");
											boid=in.nextInt();
											System.out.print("Enter the BookName       : ");
											boname=in.next();
											f2=0;k=0;
											for(BookStack b:book)
											{
												if((b.bookname.equals(boname)&&b.bookid==boid)&&b.flagBook!=false)
												{
													f2=1;
													if(b.bookCount2<b.bookCount)
													{
														book.get(k).bookCount2++;
														book.get(k).lendstdname.add(a.stdname);
														student.get(j).stdgetbook=true;
														student.get(j).lendbook=b.bookname;
													}
													if(b.bookCount2==b.bookCount)
													{
														book.get(k).flagBook=false;
													}
													break;
												}
												k++;
											}
											if(f2==0)
											{
												System.out.println("bookid or bookname Not Available...\n");
											}
											else
												System.out.println("lend successfull...\n");
										}
										else
										{
												System.out.println("Already you Lend...\n");
										}

									}
									else if(o==3)
									{	
										if(a.stdgetbook==true)
										{										
											System.out.print("Enter the BookId       : ");
											boid=in.nextInt();
											System.out.print("Enter the BookName       : ");
											boname=in.next();
											f2=0;k=0;
											if(a.lendbook.equals(boname))
											{
    											for(BookStack b:book)
    											{
    												if((b.bookname.equals(boname)&&b.bookid==boid)&&(b.flagBook==false||b.bookCount2>0))
    												{
    													f2=1;
    													if(b.bookCount2>0)
    													{
    														book.get(k).bookCount2--;
    														student.get(j).stdgetbook=false;
    														removename=0;
    														for(String str:book.get(k).lendstdname)
    														{
    															if(a.stdname.equals(str))
    															{
    																book.get(k).lendstdname.remove(removename);
    																break;
    															}
    															removename++;
    														}
    														//book.get(k).lendstdname.add(a.stdname);
    													}
    													if(b.bookCount2<b.bookCount)
    													{
    														book.get(k).flagBook=true;
    													}
    													break;
    												}
    												k++;
    											}
											}
    											else
    											{
    											   System.out.print("you are lend this book...try again");
    											}
											
											
											if(f2==0)
											{
												System.out.println("bookid or bookname Not Available...\n");
											}
											else
												System.out.println("Return successfull...\n");
										}
										else
										{
												System.out.println("You are Not Lend...\n");
										}
									}
									else if(o==4)
									{
										break;
									}
									else
										System.out.println("Wrong choice....");

								}
							}
							j++;
						}
						if(f==0)
						{
							System.out.println("wrong id or password\n");
						}
					}
					else if(m==3)
					{
						break;
					}
					else
						System.out.println("Wrong choice....");
				}
			}
			else if(n==3)
			{
				break;
			}
			else
				System.out.println("Wrong choice....");
		}
	}
}


