
package com.csbl.fms.manager;

import java.util.List;

public interface DealerManager extends Manager{
    
    public String getDealerListByParentId();
    
    public String getDealerDetails(String dealerId);
    
    public List<String> getDealerIdList();
    
}
