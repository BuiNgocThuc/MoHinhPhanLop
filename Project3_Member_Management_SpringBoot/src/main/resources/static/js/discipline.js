$("#soTien").prop('readonly', true);
$(document).on("change","#hinhThucXuLy",function (){
    if($(this).val()==="Bồi thường" || $(this).val()==="Khóa thẻ 1 tháng và bồi thường"){
        $("#soTien").prop('readonly', false);
    }else{
        $("#soTien").prop('readonly', true);
    }
})