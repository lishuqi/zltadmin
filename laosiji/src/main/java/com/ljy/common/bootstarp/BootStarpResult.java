package com.ljy.common.bootstarp;

import java.util.List;

/**
 * 分页返回对象
 * @author LSQ  
 *
 */
public class BootStarpResult {
	  private Long total;

	    private List<?> rows;

	    public BootStarpResult() {
	        super();
	    }
	    
	    public BootStarpResult(Long total, List<?> rows) {
			super();
			this.total = total;
			this.rows = rows;
		}

	    public Long getTotal() {
	        return total;
	    }

	    public void setTotal(Long total) {
	        this.total = total;
	    }

	    public List<?> getRows() {
	        return rows;
	    }

	    public void setRows(List<?> rows) {
	        this.rows = rows;
	    }

		@Override
		public String toString() {
			return "BootStarpResult [total=" + total + ", rows=" + rows + "]";
		}
}
