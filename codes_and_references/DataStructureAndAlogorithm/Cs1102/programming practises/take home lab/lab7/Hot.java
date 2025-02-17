import java.util.*;



public class Hot
{
  static int points[];
  static int weight[];
  static Interval input[];
  static Interval results[];
  
  public static void main(String[] args)
  {
    int i, j, n, num, start, end;
    int prev, numPoints, numResults;
    
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    
    points = new int[8000];
    input  = new Interval[n];
    numPoints = 0;
    
    for (i = 0; i < n; i++)
    {
      start = scan.nextInt();
      end   = scan.nextInt();
      
      if (start > 0)
      {
        points[numPoints] = start - 1;
        numPoints++;
      }
      
      points[numPoints] = start;
      numPoints++;
      
      points[numPoints] = end;
      numPoints++;
      
      points[numPoints] = end + 1;
      numPoints++;
      
      input[i] = new Interval();
      input[i].start = start;
      input[i].end   = end;
    }
    
    //sort and remove duplicate points
    Arrays.sort(points, 0, numPoints);
    
    num = 1;
    prev = points[0];
    for (i = 1; i < numPoints; i++)
    {
      if (points[i] == prev)
      {
        
      } else
      {
        points[num] = points[i];
        num++;
        prev = points[i];
      }
    }
    
    weight = new int[num];
    
    for (i = 0; i < n; i++)
    {
      for (j = 0; j < num; j++)
      {
        if (points[j] >= input[i].start && points[j] <= input[i].end)
        {
          weight[j]++;
        }
      }
    }
    
    results    = new Interval[num];
    results[0] = new Interval();
    results[0].start = points[0];
    results[0].w     = weight[0];
    numResults = 1;
    
    for (i = 1; i < num; i++)
    {
      if (weight[i] == results[numResults - 1].w)
      {
        
      } else
      {
        results[numResults - 1].end = points[i - 1]; //points[i] - 1;
        results[numResults] = new Interval();
        results[numResults].start   = points[i];
        results[numResults].w       = weight[i];
        numResults++;
      }
    }
    
    //sort and show the results
    Arrays.sort(results, 0, numResults, new IntervalComp());
    
    start = 0;
    while (results[start].w == 0)
      start++;
    System.out.print( results[start].w + ":" + "{" + "[" + results[start].start + "," + results[start].end + "]");
    
    int w = results[start].w;
    for (i = start + 1; i < numResults; i++)
    {
      if (results[i].w == w)
      {
        System.out.print("," + "[" + results[i].start + "," + results[i].end + "]");
      } else {
        System.out.println("}");
        w = results[i].w;
        System.out.print(w + ":" + "{" + "[" + results[i].start + "," + results[i].end + "]");
      }
    }
    System.out.println("}");
    
  }
}

class Interval
{
  public int w;
  public int start;
  public int end;
}

class IntervalComp implements Comparator<Interval>
{
  public int compare(Interval one, Interval two)
  {
    if(one.w == two.w)
      return one.start - two.start;
    else
      return one.w - two.w;
  }
}

