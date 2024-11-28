import pandas as pd
import plotly.express as px

df = pd.read_csv("Q3.txt", sep='\t', header=None, names=["country", "cpi_country", "finalWorth", "millionaires"])

#   Create Scatter Plot
fig = px.scatter(df, x="country", y="finalWorth")

fig.show()
