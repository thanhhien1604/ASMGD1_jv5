//package org.example.demobuoi1.repositories.asm1;
//
//import org.example.demobuoi1.entities.HoaDon;
//import org.example.demobuoi1.entities.KhachHang;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class HoaDonRepository {
//    private List<HoaDon> ds;
//
//    public HoaDonRepository() {
//        ds = new ArrayList<>();
//        ds.add(new HoaDon(1,1,1,new Date(),1));
//        ds.add(new HoaDon(2,2,2,new Date(),1));
//
//    }
//
//    public List<HoaDon> getAll() {
//        return this.ds;
//    }
//
//    public Page<HoaDon> findAllPage(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, ds.size());
//        List<HoaDon> pageContent = ds.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, ds.size());
//    }
//
//
//
//
//    public void update(HoaDon hoaDon) {
//        for (int i = 0; i < this.ds.size(); i++) {
//            HoaDon hd = this.ds.get(i);
//            if (hd.getId() == hoaDon.getId()) {
//                this.ds.set(i, hoaDon);
//                break;
//            }
//        }
//    }
//
//    public HoaDon getById(int id) {
//        for (HoaDon hd : ds) {
//            if (hd.getId() == id) {
//                return hd;
//            }
//        }
//        return null;
//    }
//
//}
