package com.ps20652.DATN.DAO;

import com.ps20652.DATN.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
    // Bạn có thể thêm các phương thức tùy chỉnh khác nếu cần
}
