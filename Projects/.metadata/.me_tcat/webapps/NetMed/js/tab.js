function tab(a,b,c) 
{ 
for(i=1;i<=b;i++){ 
if(c==i)
{ 
// 判断选择模块
document.getElementById(a+"_mo_"+i).style.display = "block";  // 显示模块内容
document.getElementById(a+"_to_"+i).className = "no";   // 改变菜单为选中样式
} 
else{ 
// 没有选择的模块
document.getElementById(a+"_mo_"+i).style.display = "none"; // 隐藏没有选择的模块
document.getElementById(a+"_to_"+i).className = "q";  // 清空没有选择的菜单样式
} 
} 
}