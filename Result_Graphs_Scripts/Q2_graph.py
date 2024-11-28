import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_csv('Q2.txt', delimiter='\t', header=None)

df = pd.DataFrame(data)

X = list(df.iloc[:, 0])
Y = list(df.iloc[:, 1])


#   Create Histogram
plt.bar(X, Y, color='b', width=1)
plt.xlabel('Age ranges')
plt.ylabel('Number of rich people')
plt.title('Rich people by age')
plt.xticks(rotation=30, ha='right')
plt.show()
