package cn.lantian.ssm.mapper;


import cn.lantian.ssm.model.DetailMateriel;

import java.util.List;

public interface DetailMaterielMapper {
    //添加材料
    public void addMateriel(DetailMateriel detailMateriel);

    //删除材料
    public void deleteMateriel(List<String> detail_Materiel_IdList);

    //修改材料
    public void updateMateriel(DetailMateriel detailMateriel);

    //查询材料列表
    public List<DetailMateriel> findAllDetailMateriel(DetailMateriel detailMateriel);

    //查询材料数量
    public int countDetailMateriel(DetailMateriel detailMateriel);

    public List<DetailMateriel> findAllDetailMaterielByName(DetailMateriel detailMateriel);

    public int countfindAllDetailMaterielByName(DetailMateriel detailMateriel);
}