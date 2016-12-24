' Array

def indexOf(array[], num)
	var i
	for i = 0 to len(array) - 1
		if array[i] == num then return i
	next
	return -1
end

def indexOf$(array$[], string$)
	var i
	for i = 0 to len(array$) - 1
		if array$[i] == string$ then return i
	next
	return -1
end

def implode$(array$[], glue$)
	var i
	var rv$
	for i = 0 to len(array$) - 1
		if i == 0 then
			rv$ = array$[i]
		else
			rv$ = rv$ + glue$ + array$[i]
		endif
	next
	return rv$
end

def arrayToStr$(array$[])
	var i
	var rv$
	for i = 0 to len(array$) - 1
		if i == 0 || array$[i] == "]" || (i > 0 && array$[i-1] == "[") then
			rv$ = rv$ + array$[i]
		else
			rv$ = rv$ + "," + array$[i]
		endif
	next
	return rv$
end

def arrDump array$[]
	? "size: " + str$(arrSize(array$))
	? "elements: " + arrayToStr$(array$)
end

def arrFlatten$(array$[])
	var i
	dim arr$[0]
	for i = 0 to len(array$) - 1
		if array$[i] != "[" && array$[i] != "]" then push arr$, array$[i]
	next
	return arr$
end

def arrSize(array$[])
	array$ = arrFlatten$(array$)
	return len(array$)
end

def arrJoin(array$[], glue$)
	var i
	var rv$
	for i = 0 to len(array$) - 1
		if array$[i] != "[" && array$[i] != "]" && rv$ == "" then
			rv$ = rv$ + array$[i]
		elseif array$[i] != "[" && array$[i] != "]" && rv$ != "" then
			rv$ = rv$ + glue$ + array$[i]
		endif
	next
	return rv$
end

def arrUniq$(array$[])
	var i
	var dimension = 1
	dim comparison$[0]
	for i = 0 to len(array$) - 1
		if array$[i] == "[" then
			inc dimension
			push comparison$, "["
		elseif array$[i] == "]" then
			dec dimension
			push comparison$, "]"
		elseif dimension == 1 && indexOf$(comparison$, array$[i]) == -1 then
			push comparison$, array$[i]
		elseif dimension > 1 then
			push comparison$, array$[i]
		endif
	next
	return comparison$
end
