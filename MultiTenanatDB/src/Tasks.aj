public aspect task {
// TODO Auto-generated aspect

private double Main.percentage=70; 
private double Main.hours;

pointcut task(Main m):call(public void Main.changeStatus())&&target(m); 
pointcut readTask(Main m):call(public void Main.getStatus())&&target(m);

private void Main.updateHoursRemaning(double hours){
System.out.println("Remaning hours left are "+hours);
}

private void Main.getStatusValue(){
System.out.println("Completion percentage is "+percentage+"%");
}

after(Main m):task(m){ m.updateHoursRemaning(9.0);
}

after(Main m):readTask(m){
m.getStatusValue();
}

}
