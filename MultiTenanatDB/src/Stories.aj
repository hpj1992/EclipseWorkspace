public aspect stories {
//TODO Auto-generated aspect
//TODO Auto-generated aspect
private String Main.projectedEndDate="23/11/2014";
pointcut task(Main m):call(public void Main.changeStatus())&&target(m); 
pointcut readTask(Main m):call(public void Main.getStatus())&&target(m);

private void Main.updateHours(double remaingHours){
System.out.println("remaning hours updated to "+remaingHours);
}

private void Main.getStatusValue(){
System.out.println("projected end date is "+projectedEndDate);
}

after(Main m):task(m){ m.updateHours(23.5);
}

after(Main m):readTask(m){
m.getStatusValue();
}

}
