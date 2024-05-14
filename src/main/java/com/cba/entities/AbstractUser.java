package com.cba.entities;

abstract class AbstractUser {
    abstract public String getUsername();

    abstract public String getPassword();

    abstract public String getAddress();

    abstract public Long getMobileNumber();

    abstract public String getEmail();

    abstract public void setUsername(String username);

    abstract public void setPassword(String password);

    abstract public void setAddress(String address);

    abstract public void setEmail(String email);

    abstract public void setCustomerId(int customerId);

    abstract public void setMobileNumber(Long mobileNumber);

    public int getCustomerId() {
        return 0;
    }


}
