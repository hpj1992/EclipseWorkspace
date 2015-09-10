package Connection;

public class ServiceProxy implements Connection.Service {
  private String _endpoint = null;
  private Connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new Connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public void signup(java.lang.String email, java.lang.String password, java.lang.String firstname, java.lang.String lastname, java.lang.String zipcode) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    service.signup(email, password, firstname, lastname, zipcode);
  }
  
  public Source.User signin(java.lang.String username, java.lang.String pwd) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signin(username, pwd);
  }
  
  public Source.Categories[] getCategories() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getCategories();
  }
  
  public void addNewBusiness(java.lang.String strName, java.lang.String strCategoryid, java.lang.String zipcode, java.lang.String contact) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    service.addNewBusiness(strName, strCategoryid, zipcode, contact);
  }
  
  public void updateReviews(java.lang.String bizid, java.lang.String userid, java.lang.String rating, java.lang.String comment, java.lang.String strOperation) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    service.updateReviews(bizid, userid, rating, comment, strOperation);
  }
  
  public void addNewCategory(java.lang.String strCatName, java.lang.String strDesc) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    service.addNewCategory(strCatName, strDesc);
  }
  
  public java.lang.String[] getBusinessOfUsers(java.lang.String userid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getBusinessOfUsers(userid);
  }
  
  public java.lang.String[] getUSersOfBusiness(java.lang.String strBizid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getUSersOfBusiness(strBizid);
  }
  
  public Source.Review[] getReviewsOfBusiness(java.lang.String bizid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getReviewsOfBusiness(bizid);
  }
  
  public void updateLastLoginTime(java.lang.String userid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    service.updateLastLoginTime(userid);
  }
  
  public Source.Business[] getBusinesses() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getBusinesses();
  }
  
  public Source.Review[] getReviewsOfUser(java.lang.String userid) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getReviewsOfUser(userid);
  }
  
  
}