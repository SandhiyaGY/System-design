from bloomfilter import BloomFilter
from random import shuffle

n=10
p=0.05

bf=BloomFilter(n,p)
print("Size of bit array:{}".format(bf.size))
print("False positive Probability:{}".format(bf.prob))
print("Number of hash functions:{}".format(bf.hash_count))

word_present = ['abound','abounds','abundance','abundant','accessible',
                'bloom','blossom','bolster','bonny','bonus','bonuses']
word_absent = ['bluff','cheater','hate','war','humanity',
               'racism','hurt','nuke','gloomy','facebook',
               'geeksforgeeks','twitter']

for item in word_present:
    bf.add_item(item)

shuffle(word_present)
shuffle(word_absent)
test_words=word_present[:5]+word_absent
shuffle(test_words)

for word in test_words:
    if bf.check(word):
        if word in word_absent:
            print("'{}' is a false positive!".format(word))
        else:
            print("'{}' is probably present!".format(word))
    else:
        print("'{}' is definitely not present!".format(word))