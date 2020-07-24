package com.epam_task_design_patterns.Design_Patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.*;


abstract class Toy implements Cloneable
{

protected String toy_type;

abstract void addToy();

public Object clone()
{
Object clone = null;
try
{
clone = super.clone();
}
catch (CloneNotSupportedException e)
{
e.printStackTrace();
}
return clone;
}
}

class ball extends Toy
{
public ball()
{
this.toy_type = "ball";
}

@Override
void addToy()
{
System.out.println("Added ball into the cart.");
}

}

class teddy extends Toy{

public teddy()
{
this.toy_type = "teddy";
}

@Override
void addToy()
{
System.out.println("Added teddy into the cart.");
}
}

class barbie_doll extends Toy{

public barbie_doll()
{
this.toy_type = "barbie_doll";
}

@Override
void addToy()
{
System.out.println("Added barbie_doll into the cart.");
}
}

class ToyStore {

private static Map<String, Toy> toyMap = new HashMap<String, Toy>();

static
{
toyMap.put("ball", new ball());
toyMap.put("teddy", new teddy());
toyMap.put("barbie_doll", new barbie_doll());
}

public static Toy getToy(String toy_type)
{
return (Toy) toyMap.get(toy_type).clone();
}
}

public class Prototype_Pattern
{
public static void main (String[] args)
{
ToyStore.getToy("ball").addToy();
ToyStore.getToy("barbie_doll").addToy();
ToyStore.getToy("teddy").addToy();
ToyStore.getToy("barbie_doll").addToy();
ToyStore.getToy("ball").addToy();
ToyStore.getToy("ball").addToy();
}
}

/*OUTPUT:
Added ball into the cart.
Added barbie_doll into the cart.
Added teddy into the cart.
Added barbie_doll into the cart.
Added ball into the cart.
Added ball into the cart.

*/