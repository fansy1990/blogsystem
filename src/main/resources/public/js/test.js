
function test1() {
    console.info("test1..."+","+$("#firstId").val());
    $.ajax({
        url:"/test/test1",
        data:{first:$("#firstId").val(),second:undefined,third:$("#thirdId").val(),fourth:"4"},
        dataType:"json",
        type:"post",
        success: function(result){
            console.info("aaa");
        }
    });
}

function test2() {
    console.info("test2...")
    $.ajax({
        url:"/test/test2",
        data:{first:$("#firstId").val(),second:$("#secondId").val(),third:$("#thirdId").val()},
        type:"post",
        dataType:"json",
        success: function(result){
            console.info("bbb");
        }
    });
}


function test3() {
    console.info("test3...")
    $.ajax({
        url:"/test/test3",
        data:{first:$("#firstId").val(),second:$("#secondId").val(),third:$("#thirdId").val()},
        type:"post",
        dataType:"json",
        success: function(result){
            console.info("ccc");
        }
    });
}