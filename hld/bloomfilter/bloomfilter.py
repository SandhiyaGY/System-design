import math
import mmh3
from bitarray import bitarray
class BloomFilter(object):
    
    def __init__(self,count,prob):
        self.count=count
        self.prob=prob
        self.size=self.get_size(count,prob)
        self.hash_count=self.get_hash_count(self.size,count)
        self.bit_array=bitarray(self.size)
        self.bit_array.setall(0)

    def get_size(self,n,p):
        m=-(n*math.log(p))/math.log(2)**2
        return int(m)
    
    def get_hash_count(self,m,n):
        k=(m/n)*math.log(2)
        return int(k)
    
    def add_item(self,item):
        bit_indices=[]
        for i in range(self.hash_count):
            bit_index=mmh3.hash(item,i)%self.size
            bit_indices.append(bit_index)
            self.bit_array[bit_index]=True

    def check(self,item):
        for i in range(self.hash_count):
            bit_index=mmh3.hash(item,i)%self.size
            if self.bit_array[bit_index]==False:
                return False
        return True


