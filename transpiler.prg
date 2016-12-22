' PROJECT SMILE++
' Smile++ Transpiler 2017.1

option strict

acls
prgEdit 1

' 配列の要素を検索する

def indexOf$(array$[], string$)
	var i
	for i = 0 to len(array$) - 1
		if array$[i] == string$ then return i
	next
	return -1
end

' 配列を生成する

def array(list$)
	dim arr[0]
	var tmp = ""
	var i
	var c$ = ""
	for i = 0 to len(list$) - 1
		c$ = mid$(list$, i, 1)
		if c$ == " " && tmp$ != "" then
			push arr, val(tmp$)
			tmp$ = ""
		endif
		tmp$ = tmp$ + c$
	next
	if tmp$ != "" && tmp$ != " " then push arr, val(tmp$)
	return arr
end

def array$(list$)
	dim arr$[0]
	var tmp$ = ""
	var i
	var c$ = ""
	for i = 0 to len(list$) - 1
		c$ = mid$(list$, i, 1)
		if c$ == " " && tmp$ != "" then
			push arr$, tmp$
			tmp$ = ""
		else
			tmp$ = tmp$ + c$
		endif
	next
	if tmp$ != "" && tmp$ != " " then push arr$, tmp$
	return arr$
end

' 配列の内容を出力する

def arrayDump arr[]
	var i
	for i = 0 to len(arr) - 1
		? str$(arr[i]) + " ";
	next
	? ""
end

def arrayDump arr$[]
	var i
	for i = 0 to len(arr$) - 1
		? arr$[i] + " ";
	next
	? ""
end

' 定数

var UNKNOWN = 1, DIRECTION = 2, RESERVED = 3
var OPERATOR = 4

' 演算子

dim operators$[0]
operators$ = array$("+ - * / DIV MOD << >> NOT ( ) == != < <= > >= && || AND OR XOR !")

' 予約語

dim reservedWords$[0]
reservedWords$ = array$("IF THEN ELSE ELSEIF ENDIF GOTO GOSUB RETURN ON FOR NEXT WHILE WEND REPEAT UNTIL BREAK CONTINUE DEF END VAR DIM DATA READ RESTORE PRINT INPUT LINPUT CALL SWAP OUT COMMON USE EXEC")

' 字句解析

def lex string$, tk$[], type[]
	var record$ = ""
	dim phase[0]
	var index = 0
	var isRecorded = false
	
	while true
		var c$ = mid$(string$, index, 1)

		if c$ == "#" then
			push phase, DIRECTION
			inc index
			isRecorded = true
		elseif c$ == " " || index == len(string$) - 1 then
			if len(phase) then
				if phase[len(phase) - 1] == UNKNOWN then
					if indexOf$(reservedWords$, record$) != -1 then phase[len(phase) - 1] = RESERVED
					if indexOf$(operators$, record$) != -1 then phase[len(phase) - 1] = OPERATOR
				endif
				push type, pop(phase)
				push tk$, record$
				record$ = ""
				isRecorded = false
			endif
			inc index
		elseif c$ != " " && isRecorded == false then
			push phase, UNKNOWN
			isRecorded = true
			inc index
		else
			inc index
		endif

		if isRecorded then record$ = record$ + c$
		if index >= len(string$) then break
	wend
end

var i, n
for n = 0 to prgSize(1) - 1
	dim tk$[0]
	dim type[0]
	lex prgGet$(), tk$, type
	for i = 0 to len(tk$)
		? tk$[i] + " " + str$(type[i])
	next
next
