public aspect cards {
// TODO Auto-generated aspect private 
String Main.swimLanes; 
private double Main.cycleTime=23.5;

pointcut task(Main m):call(public void Main.changeStatus())&&target(m);
 pointcut readTask(Main m):call(public void Main.getStatus())&&target(m);

private void Main.updateSwimlane(String swimLane){
System.out.println("Swimlane updated to "+swimLane);
}

private void Main.getStatusValue(){
System.out.println("CycleTime in swimLane "+cycleTime);
}

after(Main m):task(m){
m.updateSwimlane("Completed");

}

after(Main m):readTask(m){
m.getStatusValue();
}

}

