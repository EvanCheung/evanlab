select 

 from atwritinfo 



 --
select 
id as '文件ID',
archregid as '所在案卷id' , 
file no as '文件编号' , 
createddate as '文件日期' , 
recvfileno as '收文编号' , 
writeperson as '拟稿人' ,
signatureperson  as '签发人' ,
titleword as '主题词' ,
urgent as '紧急程度' ,
media as '载体类型' ,
texttype as '稿本' ,
signindate as '签发日期' ,
fileowner as '责任者' ,
maincontent as '内容提要' ,
note as '备注' ,
filetitle as '文件题名' , 
secret as '密级' , 
filecopies as '文件份数' ,
appendixtitle as '附件说明' ,
seqid as '件号' , 
unitcode as '全宗号' ,
pages as '页数' ,
beginpage as '起始页号' ,
filearchno as '文件档号' ,
archdate as '归档日期' ,
archdept as '归档部门' ,
archperson as '归档人' ,
typecode as '类名' ,
archyear as '归档年份' ,
expired as '保管期限' ,
place as '档案馆代号' , 
ecode as '电子文档号' ,
standard as '规格' ,
unit as '单位' ,
 docid as '附件ID' ,
 tounit as '主送单位' ,
 copyunit as '抄送单位'
 from atwritinfo 


 



select 
id as '文件ID',
archregid as '所在案卷id' , 
case subtype when '1' then '收文' when '2' then '发文' else '内部文件' end as '收发类型',
fileno as '文件编号' , 
createddate as '文件日期' , 
recvfileno as '收文编号' , 
writeperson as '拟稿人' ,
signatureperson  as '签发人' ,
titleword as '主题词' ,
urgent as '紧急程度' ,
media as '载体类型' ,
texttype as '稿本' ,
signindate as '签发日期' ,
fileowner as '责任者' ,
maincontent as '内容提要' ,
note as '备注' ,
filetitle as '文件题名' , 
secret as '密级' , 
filecopies as '文件份数' ,
appendixtitle as '附件说明' ,
seqid as '件号' , 
unitcode as '全宗号' ,
pages as '页数' ,
beginpage as '起始页号' ,
filearchno as '文件档号' ,
archdate as '归档日期' ,
archdept as '归档部门' ,
archperson as '归档人' ,
typecode as '类名' ,
archyear as '归档年份' ,
expired as '保管期限' ,
place as '档案馆代号' , 
ecode as '电子文档号' ,
standard as '规格' ,
unit as '单位' ,
 docid as '附件ID' ,
 tounit as '主送单位' ,
 copytounit as '抄送单位'
 from atwritinfo 



select 
ataccount.id as '文件ID',
archregid as '所在案卷id' , 
fileno as '文件编号' , 
create_date as '文件日期' , 
fileowner as '责任者' ,
ataccount.notes as '备注' ,

filetitle as '文件题名' , 
secret as '密级' , 

seqid as '件号' , 
ataccount.unitcode as '全宗号' ,
pages as '页数' ,
beginpage as '起始页号' ,
filearchno as '文件档号' ,
archdate as '归档日期' ,
ataccount.archdept as '归档部门' ,
archperson as '归档人' ,
ataccount.typecode as '类名' ,
archyear as '归档年份' ,
ataccount.expired as '保管期限' ,
place as '档案馆代号' , 
ecode as '电子文档号' ,


 docid as '附件ID' 

 from ataccount 

inner join sttypecode c 
on ataccount.typecode = c.typecode