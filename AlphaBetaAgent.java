import java.io.*;
import java.awt.Point;
import java.util.*;
public class AlphaBetaAgent {
   
int depth;
State st;
int x;
    
public AlphaBetaAgent(int depth)
{
this.depth = depth;
}

    public static  double A = 10000000;
    public static  double B = -10000000;

    public int APSearch(State st) throws CloneNotSupportedException
    {
     double val = max_value(st, depth ,A , B );
     return x;
    }
    public double max_value(State st, int d , double A , double B ) throws CloneNotSupportedException
    {
    ArrayList<Integer> children = new ArrayList<Integer>();
    if(d == 0)
    return st.evaluationFunction();
    else{
    children = st.getLegalActions();
    double v = -10000000;

 for(int i =0; i<children.size();i++)
 { 
 v = Math.max( v , min_value(st.generateSuccessor('O',children.get(i),d , st) , d , A , B )) ;
  if(v >= B)
 {
	this.x=i;
    return v;
 }
    A = Math.max(A , v);
}

return v; }//else
}

 public double min_value(State st, int d , double A , double B  ) throws CloneNotSupportedException
{

ArrayList<Integer> children = new ArrayList<Integer>();
if(d == 0)
return st.evaluationFunction();
else
{
children = st.getLegalActions();
double v = 10000000;
for(int i =0; i<children.size();i++)
{
v = Math.min( v, max_value(st.generateSuccessor('X',children.get(i),d-1,st) , d , A , B ));
if(v <= A){
	this.x=i;
    return v;
           }
 B = Math.min(B , v);
}
return v;
}
}
}

