# lftc
Limbaje formale si tehnici de compilare - Lab Work for lab2 (Documentation)

The Symbol Table is implemented as a alphabetically sorted array list.

It contains the following methods:

public boolean containsValue(String valueItem)
  Method verifying if the value provided as input is found in the ST
  @param valueItem the value to be searched for
  @return true if value is found, false otherwise

public void put(int index, String symbol)
  Method that inserts the given symbol with the corresponding index alphabetically in the ST
  @param index position in the ST
  @param symbol symbol in the ST - can be either a variable or a constant
  How it works: the algorithm searches for existing entries in the ST and inserts the symbol provided as parameter based on the position in the alphabet; if the symbol already exists in the list it replaces it with the new symbol code
  
public Integer getPosition(String symbol)
  Method receives a symbol and returns its position in the ST
  @param symbol to be searched for
  @return integer position for symbol in ST
  
public void printSymbolTable()
  Display ST

    
    
      


