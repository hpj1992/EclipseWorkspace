/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public interface Service extends java.rmi.Remote {
    public void signup(java.lang.String email, java.lang.String password, java.lang.String firstname, java.lang.String lastname, java.lang.String zipcode) throws java.rmi.RemoteException;
    public Source.User signin(java.lang.String username, java.lang.String pwd) throws java.rmi.RemoteException;
    public Source.Categories[] getCategories() throws java.rmi.RemoteException;
    public void addNewBusiness(java.lang.String strName, java.lang.String strCategoryid, java.lang.String zipcode, java.lang.String contact) throws java.rmi.RemoteException;
    public void updateReviews(java.lang.String bizid, java.lang.String userid, java.lang.String rating, java.lang.String comment, java.lang.String strOperation) throws java.rmi.RemoteException;
    public java.lang.String[] getBusinessOfUsers(java.lang.String userid) throws java.rmi.RemoteException;
    public java.lang.String[] getUSersOfBusiness(java.lang.String strBizid) throws java.rmi.RemoteException;
    public Source.Review[] getReviewsOfBusiness(java.lang.String bizid) throws java.rmi.RemoteException;
    public void updateLastLoginTime(java.lang.String userid) throws java.rmi.RemoteException;
    public Source.Business[] getBusinesses() throws java.rmi.RemoteException;
    public Source.Review[] getReviewsOfUser(java.lang.String userid) throws java.rmi.RemoteException;
    public void addNewCategory(java.lang.String strCatName, java.lang.String strDesc) throws java.rmi.RemoteException;
}
