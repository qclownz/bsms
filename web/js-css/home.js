$(document).ready(function(){  // 获取总的统计信息
        $.ajax({
            type:'get',
            url:'/bsms/allinfo',
            cache: false,
            dataType:'json',
            success:function(data){
                $('#bookKinds').text(data.bookKinds + '(种)');
                $('#bookAmounts').text(data.bookAmounts + '(本)');
                $('#bookValues').text(data.bookValues.toFixed(2) + '(元)');
                $('#memberAmounts').text(data.memberAmounts + '(人)');
                $('#saleAmounts').text(data.saleAmounts + '(本)');
                $('#saleValues').text(data.saleValues.toFixed(2) + '(元)');
            },
            error:function(){
                alert("书店信息请求失败!")
            }
        })
});

$(document).ready(function(){  // 统计实时信息
    $.ajax({
        type:'get',
        url:'/bsms/nowinfo',
        cache: false,
        dataType:'json',
        success:function(data){
            $('#todayAmounts').text(data.todayAmounts + '(本)');
            $('#todayValues').text(data.todayValues.toFixed(2) + '(元)');
            $('#thisMonthAmounts').text(data.thisMonthAmounts + '(本)');
            $('#thisMonthValues').text(data.thisMonthValues.toFixed(2) + '(元)');
        },
        error:function(){
            alert("销售信息请求失败!")
        }
    })
});

$(document).ready(function(){  // 退出系统
    $("#exit").click(function(){
        if(confirm("您确定要退出系统吗?")) {
            window.close();
        }
    });
});

$(document).ready(function(){
    $("a").hover(function(){
        $(this).css("color","#ff7171");
    },function(){
        $(this).css("color","#000")
    });
});
