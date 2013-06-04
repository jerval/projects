//FCKConfig.AutoDetectLanguage	= false ;
//FCKConfig.DefaultLanguage		= 'zh' ;
//"黑体", "宋体", "微软雅黑", "新宋体"
FCKConfig.FontNames		= '黑体;宋体;微软雅黑;新宋体;Tahoma;Times New Roman' ;
FCKConfig.ToolbarSets["Custom"] = [
	['Source','DocProps'],
	['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],
	'/',
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Table','Rule','Smiley','SpecialChar','PageBreak'],
	'/',
	['Style','FontFormat','FontName','FontSize'],
	['TextColor','BGColor'],
	['FitWindow','ShowBlocks','-','About']		// No comma for the last row.
] ;

FCKConfig.EnterMode = 'br';			// p | div | br
FCKConfig.ShiftEnterMode = 'p' ;	// p | div | br