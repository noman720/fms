
package com.csbl.fms.service.impl;

import com.csbl.fms.service.QueryManager;
import com.csbl.fms.util.Constant;
import com.csbl.fms.util.TableName;




public class MySqlQueryManagerImpl implements QueryManager, Constant {
    
    @Override
    public String getUserForLogin() {
        String sql = "select u.userId, u.userFullName, u.userPassword, u.enabled, u.roleName"
            + " from "+TableName.USER+" u"
            + " where u.userId = ?";
        return sql;
    }
    
    @Override
    public String getSaveUserSQL()
    {
        String sql = "insert into "+TableName.USER+" ("
                + "oid, userId, userFullName, "
                + "userPassword, enabled, createdDate, "
                + "emailId, roleName) "
                + "values ("
                + "?, ?, ?, "
                + "?, ?, ?, "
                + "?, ?)";
        
        return sql;
    }
    
    
    @Override
    public String getUpdateAppDealerSQL()
    {
        String sql = "update "+TableName.DEALER_APP+" set isSelected = 'Yes' where appYear = ? and nationalId = ?";
        
        return sql;
    }
    
    @Override
    public String getParentDealerIdListSQL()
    {
        String sql = "select dealerId from "
                + TableName.DEALER+" where dealerRole = ?";
                
        return sql;
    }
    
    @Override
    public String getApplicantDealerByAppYearAndPostCodeSQL()
    {
        String sql = "select dealerRole, nationalId, dealerName, mobileNo, isSelected from "
                + TableName.DEALER_APP+" "
                + "where appYear = ? and postCode = ?";
        return sql;
    }
    
    @Override
    public String getApplicantDealerDetailsSQL()
    {
        String sql = "select * from "
                + TableName.DEALER_APP+" "
                + "where appYear = ? and nationalId = ?";
        return sql;
    }
    
    
    @Override
    public String getAllCropsNameSQL()
    {
        String sql = "select cropsName from "+TableName.CROPS;
        return sql;
    }

    @Override
    public String getAllFertilizerIdSQL()
    {
        String sql = "select fertiName from "+TableName.FERTILIZER;
        return sql;
    }
    
    @Override
    public String getAllPostCodeSQL()
    {
        String sql = "select postcode from "+TableName.POSTCODE;
        return sql;
    }

    
    @Override
    public String getAllSeasionNameSQL()
    {
        String sql = "select seasionName from "+TableName.SEASION;
        return sql;
    }
    
    
    @Override
    public String getFarmerListByDealerSQL()
    {
        String sql = "select farmerId, nationalId, farmerName, mobileNo from "+TableName.FARMER+" where dealerId = ?";
        return sql;
    }
    
    @Override
    public String getFarmerIdListByDealerSQL()
    {
        String sql = "select farmerId from "+TableName.FARMER+" where dealerId = ?";
        return sql;
    }
    
    @Override
    public String getFarmerDetailsSQL()
    {
        String sql = "select * from "+TableName.FARMER+" where farmerId = ?";
        return sql;
    }
    
    @Override
    public String getDealerListByParentIdSQL()
    {
        String sql = "select appYear, dealerId, nationalId, dealerName, mobileNo from "+TableName.DEALER+" where parentId = ?";
        return sql;
    }
    
    @Override
    public String getDealerDetailsSQL()
    {
        String sql = "select * from "+TableName.DEALER+" where dealerId = ?";
        return sql;
    }
    
    
    @Override
    public String getDealerIdListByUserSQL()
    {
        String sql = "select dealerId from "+TableName.DEALER+" where parentId = ?";
        return sql;
    }
    
    
    @Override
    public String getCropsListSQL()
    {
        String sql = "select * from "+TableName.CROPS;
        return sql;
    }
    
    @Override
    public String getFertilizerListSQL()
    {
        String sql = "select * from "+TableName.FERTILIZER;
        return sql;
    }
    
    @Override
    public String getRecommendedValeSQL()
    {
        String sql = "select * from "+TableName.RECOMMENDATION+" where postCode = ? and cropsName = ? and fertiName = ?";
        return sql;
    }
    
    
    @Override
    public  String getFarmerAllotmentReportSQL()
    {
        //select farmerId, seasionYear, seasionName, fertiName, sum(fertiAmount) as fertiAmount, fertiUnit, sum(landAmount) as landAmount, landUnit  from t_total_ferti_farmer_detail group by farmerId, fertiName
//        String sql = "select fdtable.farmerId, seasionYear, seasionName, fertiName, sum(fertiAmount) as fertiAmount, "
//                + "fertiUnit, sum(landAmount) as landAmount, landUnit, ftable.farmerId from "+TableName.TOTAL_FERTI_FARMER+" fdtable, "+TableName.FARMER+" ftable "
//                + "where ftable.dealerId=? and ftable.farmerId=fdtable.farmerId group by fdtable.farmerId, fertiName";
        
        String sql = "select temp1.farmerId, temp1.seasionYear, temp1.seasionName, temp1.fertiName, ifnull(temp1.totalAllotedAmount,0) as totalAllotedAmount, temp1.totalAllotedAmountUnit, "
                + "ifnull(temp2.totalTransactedAmount,0) as totalTransactedAmount, ifnull(temp2.totalTransactedAmountUnit, 'Kilogram') as totalTransactedAmountUnit "
                
                + "from "
                + "(select farmerId, seasionYear, seasionName, fertiName ,ifnull(sum(fertiAmount),0) as totalAllotedAmount, fertiUnit as totalAllotedAmountUnit from "
                + TableName.TOTAL_FERTI_FARMER+" t1 where t1.farmerId in (select farmerId from "+TableName.FARMER+" where dealerId = ?) "
                + "group by farmerId, seasionYear, seasionName, fertiName) temp1 "

                + "left join "

                + "(select farmerId, seasionYear, seasionName, fertiName, ifnull(sum(fertiAmount),0) as totalTransactedAmount, fertiUnit as totalTransactedAmountUnit from "
                + TableName.FERTI_FARMER_TRANSACTION+" t2 where t2.farmerId in (select farmerId from "+TableName.FARMER+" where dealerId = ?) "
                + "group by farmerId, seasionYear, seasionName, fertiName) temp2 "

                + "on temp1.farmerId=temp2.farmerId and temp1.fertiName=temp2.fertiName and temp1.seasionYear=temp2.seasionYear "
                + "and temp1.seasionName=temp2.seasionName";
        
        
        return sql;
    }
    
    //get final allotment report to the author for estimation
    @Override
    public  String getAuthorAllotmentReportSQL()
    {
        //select farmerId, seasionYear, seasionName, fertiName, sum(fertiAmount) as fertiAmount, fertiUnit, sum(landAmount) as landAmount, landUnit  from t_total_ferti_farmer_detail group by farmerId, fertiName
//        String sql = "select seasionYear, seasionName, fertiName, fertiAmount, "
//                + "fertiUnit, landAmount, landUnit from "+TableName.TOTAL_FERTI_DEALER+" tfdtable, "+TableName.DEALER+" dtable "
//                + "where dtable.dealerRole=? and tfdtable.dealerId=dtable.dealerId";
        //System.out.println(sql);
        
        
//        String sql = "select t1.dealerId, t1.seasionYear, t1.seasionName, t1.fertiName, ifnull(sum(t1.fertiAmount),0) as totalAllotedAmount, "
//                + "t1.fertiUnit as totalAllotedAmountUnit, ifnull(sum(t2.fertiAmount), 0) as totalTransactedAmount, t2.fertiUnit as totalTransactedAmountUnit "
//                + "from "+TableName.TOTAL_FERTI_DEALER+" t1 "
//                + "left join "+TableName.FERTI_DEALER_TRANSACTION+" t2 on t1.dealerId=t2.toDealer and t1.seasionYear=t2.seasionYear and t1.seasionName=t2.seasionName and t1.fertiName = t2.fertiName "
//                + "where t1.dealerId=? "
//                + "group by t1.dealerId, t1.seasionYear, t1.seasionName, t1.fertiName";
        
        
        String sql = "select temp1.seasionYear, temp1.seasionName, temp1.fertiName, ifnull(temp1.totalAllotedAmount,0) as totalAllotedAmount, temp1.totalAllotedAmountUnit, "
                + "ifnull(temp2.totalTransactedAmount,0) as totalTransactedAmount, ifnull(temp2.totalTransactedAmountUnit, 'Metrictone') as totalTransactedAmountUnit "
                + "from "
                + "(select dealerId, seasionYear, seasionName, fertiName ,ifnull(sum(fertiAmount),0) as totalAllotedAmount, fertiUnit as totalAllotedAmountUnit from "
                + TableName.TOTAL_FERTI_DEALER+" t1 where t1.dealerId=? "
                + "group by seasionYear, seasionName, fertiName) temp1 "

                + "left join "

                + "(select toDealer, seasionYear, seasionName, fertiName, ifnull(sum(fertiAmount),0) as totalTransactedAmount, fertiUnit as totalTransactedAmountUnit from "
                + TableName.FERTI_DEALER_TRANSACTION+" t2 where t2.toDealer=? "
                + "group by seasionYear, seasionName, fertiName) temp2 "

                + "on temp1.fertiName=temp2.fertiName and temp1.seasionYear=temp2.seasionYear "
                + "and temp1.seasionName=temp2.seasionName";

        return sql;
    }
    
    
    
    //get allotmet report for dealer
    @Override
    public  String getDealerAllotmentReportSQL()
    {
        
        String sql = "select temp1.dealerId, temp1.seasionYear, temp1.seasionName, temp1.fertiName, ifnull(temp1.totalAllotedAmount,0) as totalAllotedAmount, temp1.totalAllotedAmountUnit, "
                + "ifnull(temp2.totalTransactedAmount,0) as totalTransactedAmount, ifnull(temp2.totalTransactedAmountUnit, 'Metrictone') as totalTransactedAmountUnit "
                + "from "
                + "(select dealerId, seasionYear, seasionName, fertiName ,ifnull(sum(fertiAmount),0) as totalAllotedAmount, fertiUnit as totalAllotedAmountUnit from "
                + TableName.TOTAL_FERTI_DEALER+" t1 where t1.dealerId in (select dealerId from "+TableName.DEALER+" where parentId = ?) "
                + "group by dealerId, seasionYear, seasionName, fertiName) temp1 "

                + "left join "

                + "(select toDealer, seasionYear, seasionName, fertiName, ifnull(sum(fertiAmount),0) as totalTransactedAmount, fertiUnit as totalTransactedAmountUnit from "
                + TableName.FERTI_DEALER_TRANSACTION+" t2 where t2.toDealer in (select dealerId from "+TableName.DEALER+" where parentId = ?) "
                + "group by toDealer, seasionYear, seasionName, fertiName) temp2 "

                + "on temp1.fertiName=temp2.fertiName and temp1.seasionYear=temp2.seasionYear "
                + "and temp1.seasionName=temp2.seasionName";

        return sql;
    }
    
    
    
    //for dealer and author transaction
    @Override
    public String getAllotedValueByAuthorSQL()
    {
        String sql = "select tfdtable.fertiAmount as totalAllotedAmount, tfdtable.fertiUnit as totalAllotedAmountUnit "
                + "from "+TableName.TOTAL_FERTI_DEALER+" tfdtable "
                + "where tfdtable.seasionYear=? and tfdtable.seasionName=? and tfdtable.fertiName=? and tfdtable.dealerId=?";
        
        System.out.println(sql);
        
        return sql;
    }
    
    @Override
    public String getTransactedValueByAuthorSQL()
    {
        String sql = "select sum(fdttable.fertiAmount) as totalTransactedAmount, fdttable.fertiUnit as totalTransactedAmountUnit "
                + "from "+TableName.FERTI_DEALER_TRANSACTION+" fdttable "
                + "where fdttable.seasionYear=? and fdttable.seasionName=? and fdttable.fertiName=? and fdttable.toDealer=? "
                + "group by seasionYear, seasionName, fertiName, toDealer";
        
        System.out.println(sql);
        
        return sql;
    }
    
    
    
    //for farmer transaction
    @Override
    public String getAllotedValueForFarmerSQL()
    {
        String sql = "select sum(tfdtable.fertiAmount) as totalAllotedAmount, tfdtable.fertiUnit as totalAllotedAmountUnit "
                + "from "+TableName.TOTAL_FERTI_FARMER+" tfdtable "
                + "where tfdtable.seasionYear=? and tfdtable.seasionName=? and tfdtable.fertiName=? and tfdtable.farmerId=? "
                + "group by seasionYear, seasionName, fertiName, farmerId";
        
        System.out.println(sql);
        
        return sql;
    }
    
    
    @Override
    public String getTransactedValueForFarmerSQL()
    {
        String sql = "select sum(fdttable.fertiAmount) as totalTransactedAmount, fdttable.fertiUnit as totalTransactedAmountUnit "
                + "from "+TableName.FERTI_FARMER_TRANSACTION+" fdttable "
                + "where fdttable.seasionYear=? and fdttable.seasionName=? and fdttable.fertiName=? and fdttable.farmerId=? "
                + "group by seasionYear, seasionName, fertiName, farmerId";
        
        System.out.println(sql);
        
        return sql;
    }
}
