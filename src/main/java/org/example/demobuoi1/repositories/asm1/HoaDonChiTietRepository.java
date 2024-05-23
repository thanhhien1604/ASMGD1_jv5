package org.example.demobuoi1.repositories.asm1;

import org.example.demobuoi1.entities.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietRepository {
    private List<HoaDonChiTiet> ds;

    public HoaDonChiTietRepository(){
        ds = new ArrayList<>();
        ds.add(new HoaDonChiTiet(1,1,1,15,300.000,1));
        ds.add(new HoaDonChiTiet(2,2,2,20,2400.000,0));
    }

    public List<HoaDonChiTiet> getAll(){
        return this.ds;
    }

    public Page<HoaDonChiTiet> findAllPage(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int startIndex = pageNumber * pageSize;
        int endIndex = Math.min(startIndex + pageSize, ds.size());
        List<HoaDonChiTiet> pageContent = ds.subList(startIndex, endIndex);
        return new PageImpl<>(pageContent, pageable, ds.size());
    }


    public HoaDonChiTiet getById(int id){
        for (int i = 0; i < this.ds.size(); i++){
            HoaDonChiTiet hdct = this.ds.get(i);
            if (hdct.getId() == id){
                return hdct;
            }
        }
        return null;


    }

}
