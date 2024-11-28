import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_csv('Q1a.txt', delimiter='\t', header=None)

df = pd.DataFrame(data)

X = list(df.iloc[:, 0])
Y = list(df.iloc[:, 1])


#   Create Bar Chart
plt.bar(X, Y, color='g', width=.8)
plt.xlabel('Category')
plt.ylabel('Times Found')
plt.title('Studying the attributes')
plt.xticks(rotation=30, ha='right')
plt.show()
