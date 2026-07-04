Hands-on 2 – Query Methods on Stock Table

What are Advanced Query Creation Methods
We can define complex query rules using Spring Data JPA method names. For example, using multiple properties (like Code and DateBetween) or introducing limiting clauses (like Top3).

Queries Implemented
- findByCodeAndDateBetween: Combines two columns code (st_code) and date (st_date) using AND condition, checking if the date falls between start and end LocalDates.
- findByCodeAndCloseGreaterThan: Finds stock records by ticker code where the closing price exceeds a specific threshold.
- findTop3ByOrderByVolumeDesc: Orders all stock records by transaction volume in descending order and returns only the top 3 records (equivalent to ORDER BY volume DESC LIMIT 3).
- findTop3ByCodeOrderByCloseAsc: Finds the 3 records for a specific stock code with the lowest closing prices (equivalent to WHERE code = ? ORDER BY close ASC LIMIT 3).
