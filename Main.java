import java.io.*;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList<Person> people = new ArrayList<Person>();
    Person p1 = new Person("Tyler", 23, "black");
    Person p2 = new Person("Katie", 23, "brown");
    Person p3 = new Person("Andrew", 21, "cyan");
    Person p4 = new Person("Anton", 22, "lime");
    Person p5 = new Person("Danny", 22, "orange");

    people.add(p1);
    people.add(p2);
    people.add(p3);
    people.add(p4);
    people.add(p5);

    try {
      FileWriter writeFile = new FileWriter("data.txt");

      BufferedWriter output = new BufferedWriter(writeFile);

      for(int i=0; i<people.size(); i++) {
        output.write(people.get(i).getName());
        output.newLine();
        output.write(Integer.toString(people.get(i).getAge()));
        output.newLine();
        output.write(people.get(i).getColor());
        output.newLine();

        output.flush();
      }
      output.close();
    }
    catch (IOException e) { 
      e.printStackTrace();
    }

  try {
    String filename = "data.txt";
    FileReader myFile = new FileReader(filename);
    String name = "", age = "", color = "";

    BufferedReader reader = new BufferedReader(myFile);

    while (reader.ready()) {
      name = reader.readLine();
      age = reader.readLine();
      color = reader.readLine();
      Person thePerson = new Person(name, Integer.parseInt(age), color);

      System.out.printf("%-10s %-10s %-10s %n", name, age, color);
    }
    reader.close();
  }
  catch (IOException ex) {
    ex.printStackTrace();
  }
}
}