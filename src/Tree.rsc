module Tree

import IO;
import List; 


data Either = left(int v) | right(str err);


@javaClass{Factory}
@reflect{for stdout}
java list[Either] createValues();

test bool testSizeOfTheList() {
   list[Either] v = createValues();
   
   return size(v) == 3; 
}

test bool testCreateValues() {
   list[Either] v = createValues(); 
   println("Created values  <v> \n"); 
   
   Either e1 = left(1); 
   Either e2 = left(2); 
   Either e3 = right("foo");
   
   println("Note: "); 
   println("- e1 = <e1> and v[0] = <v[0]>. Test e1 == v[0] leads to <e1 == v[0]>"); 
   println("- e2 = <e2> and v[1] = <v[1]>. Test e2 == v[1] leads to <e2 == v[1]>"); 
   println("- e3 = <e3> and v[2] = <v[2]>. Test e3 == v[2] leads to <e2 == v[1]> \n"); 
   
   println("The test e1 := v[0] also leads to <e1 := v[0]>. \n"); 
   
   
   return v[0] == e1 && v[1] == e2 && v[2] == e3; 
}