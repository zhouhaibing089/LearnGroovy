def number = 1

def normalString = "${number}"
def lazyString = "${-> number}"

println 'NormalString: ' + normalString
println 'LazyString: ' + lazyString

number = 4

println 'NormalString: ' + normalString
println 'LazyString: ' + lazyString
