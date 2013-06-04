
package com.jvwl.dao;

import com.jvwl.model.Admin;

public interface AdminDao {
public boolean login(Admin admin);
public boolean updatePassword(Admin admin);
}
