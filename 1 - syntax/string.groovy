    def str1 = '''
        HelloWorld, I suppose this is the first line.
        And this is the second line with an indentation
    '''

println str1

println "==========="

def str2 = '''\
Now the first empty line disappeared
'''

println str2

println "==========="

def str3 = '''\
Now the last empty line disappeared'''

println str3

println "==========="

println str1.stripIndent()
